package abyssTeamGen;

import Utilities.Tuple;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *  Generates two 4-character teams for use in the Spiral Abyss
 *  Provides elemental resonances for each team and elemental reaction possibilities
 */
public class AbyssTeamApp extends CharacterIO {

    private String data;
    private ArrayList<Character> characters;
    private Character[] abyssTeam1;
    private Character[] abyssTeam2;
    private static final int ABYSS_TEAM_SIZE = 4;


    /**
     * Constructs an Abyss Team Generator App from an ArrayList of Characters
     * @param characters ArrayList of Characters
     */
    public AbyssTeamApp(ArrayList<Character> characters) {
        this.data = "ArrayList";
        this.characters = characters;
        abyssTeam1 = new Character[ABYSS_TEAM_SIZE];
        abyssTeam2 = new Character[ABYSS_TEAM_SIZE];
        this.randomTeamGenerator();


    }

    /**
     * Constructs an Abyss Team Generator App from a text file
     * @param data formatted csv
     */
    public AbyssTeamApp(String data) {
        try {
            characters = this.readDataFromFile(data);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.data = "file \"" + data + "\"";
        abyssTeam1 = new Character[ABYSS_TEAM_SIZE];
        abyssTeam2 = new Character[ABYSS_TEAM_SIZE];
        this.randomTeamGenerator();
    }

    /**
     * Generates a random Character from the initialized ArrayList of Characters
     * @return a random Character
     */
    public Character randomCharacter() {
        int i = 0;
        i = (int)(Math.random() * (characters.size() - 1));

        return characters.get(i);
    }

    /**
     * Generates a random Character from a given ArrayList of Characters
     * @param tempCharacters ArrayList of Characters
     * @return a random Character
     */
    public static Character randomCharacter(ArrayList<Character> tempCharacters) {
        int i = 0;
        i = (int)(Math.random() * (tempCharacters.size() - 1));

        return tempCharacters.get(i);
    }

    /**
     * Generates 2 teams of 4 characters each for your Abyssal runs
     * Teams can be accessed with getters for abyssTeam1 and abyssTeam2
     */
    public void randomTeamGenerator(){
        ArrayList<Character> tempAbyssTeam = new ArrayList<>();
        Character tempChara = null;
        while(tempAbyssTeam.size() <= ABYSS_TEAM_SIZE * 2) {
            tempChara = randomCharacter();
            if(!tempAbyssTeam.contains(tempChara) && tempChara != null) {
                tempAbyssTeam.add(tempChara);
            }
            else{
                // System.out.println("Character duplicate skipped");
            }
        }
        for(int w = 0; w < ABYSS_TEAM_SIZE; w++) {
            abyssTeam1[w] = tempAbyssTeam.get(w);
            abyssTeam2[w] = tempAbyssTeam.get(w + ABYSS_TEAM_SIZE);
        }

    }

    /**
     * Generates a single team of characters of *any length* for your Abyssal runs
     * Replaces the Array provided with said Abyssal team
     * @param tempCharacters An ArrayList of the Characters you own
     * @param tempTeam An Array of the length you need for your Abyssal team
     */
    public static void randomTeamGenerator(ArrayList<Character> tempCharacters, Character[] tempTeam) throws ArrayIndexOutOfBoundsException{

        if(tempTeam.length < tempCharacters.size()) {
            ArrayList<Character> tempAbyssTeam = new ArrayList<>();
            Character tempChara = null;
            while (tempAbyssTeam.size() <= tempTeam.length) {
                tempChara = randomCharacter(tempCharacters);
                if (!tempAbyssTeam.contains(tempChara)) {
                    tempAbyssTeam.add(tempChara);
                }
                else{
                    System.out.println("Character duplicate skipped");
                }
            }
            for (int x = 0; x < tempTeam.length; x++) {
                tempTeam[x] = tempAbyssTeam.get(x);
            }
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Generates all elemental reactions possible given a particular team
     * @param team Array of Characters
     * @return HashSet of Strings for the reactions possible
     */
    public static HashSet<String> generateReactions(Character[] team) {
        ArrayList<Tuple<Element, Element>> combinations = new ArrayList<>();
        HashSet<String> reactions = new HashSet<>();
        for(Character chara1 : team) {
            for(Character chara2 : team) {
                // make sure you are not matching characters with themselves
                if(!chara1.equals(chara2)) {
                    combinations.add(new Tuple<Element, Element>(chara1.getVision(), chara2.getVision()));
                }
            }
        }

        for(Tuple<Element, Element> comb : combinations) {
            reactions.add(Element.getReaction(comb.getOne(), comb.getTwo()));
        }

        // get rid of "No reaction" as a reaction if it is not the only reaction generated
        if (reactions.size() > 1) {
            reactions.remove("No reaction");
        }
        return reactions;
    }

    /**
     * Generates the elemental resonance(s) present in a team comp
     * @param team Team for resonance generation; If there are fewer than 4 memebers, returns no resonances; If there are more than four memebers, returns null;
     * @return Elemental resonance or null if there are more than 4 members
     */
    public static ArrayList<Resonance> generateElementalResonance(Character[] team) {
        ArrayList<Resonance> resonances = new ArrayList<>();
        if (team.length > 4) {
            return null;
        }
        else if(team.length < 4) {
            resonances.add(Resonance.NO_RESONANCE);
            return resonances;
        }

        // counts
        int pyro = 0;
        int cryo = 0;
        int hydro = 0;
        int electro = 0;
        int anemo = 0;
        int geo = 0;
        int dendro = 0;

        // find out how many characters of each element
        for(Character chara : team) {
            Element vis = chara.getVision();
            switch (chara.getVision()) {
                case PYRO:
                    pyro++;
                    break;
                case CRYO:
                    cryo++;
                    break;
                case HYDRO:
                    hydro++;
                    break;
                case ELECTRO:
                    electro++;
                    break;
                case ANEMO:
                    anemo++;
                    break;
                case GEO:
                    geo++;
                    break;
                case DENDRO:
                    dendro++;
                    break;
            }
        }

        // calculate the resonance of the team
        if(pyro < 2 && cryo < 2 && hydro < 2 && electro < 2 && anemo < 2 && geo < 2 && dendro < 2) {
            resonances.add(Resonance.PROTECTIVE_CANOPY);
        }
        else {
            if (pyro > 1) {
                resonances.add(Resonance.FERVENT_FLAMES);
            }
            if (cryo > 1) {
                resonances.add(Resonance.SHATTERING_ICE);
            }
            if (hydro > 1) {
                resonances.add(Resonance.SOOTHING_WATER);
            }
            if (electro > 1) {
                resonances.add(Resonance.HIGH_VOLTAGE);
            }
            if (anemo > 1) {
                resonances.add(Resonance.IMPETUOUS_WINDS);
            }
            if (geo > 1) {
                resonances.add(Resonance.ENDURING_ROCK);
            }
            if (dendro > 1) {
                resonances.add(Resonance.NO_RESONANCE);
            }


        }

        return resonances;
    }

    /**
     * gets the 1st Abyss Team
     * @return abyssTeam1
     */
    public Character[] getAbyssTeam1() {
        return abyssTeam1;
    }

    /**
     * gets the 2nd Abyss Team
     * @return abyssTeam2
     */
    public Character[] getAbyssTeam2() {
        return abyssTeam2;
    }

    /**
     * The messy body of the program that contains the business logic
     * Prints the data to the console in a human-readable way
     */
    public void run() {
        /*
        for(Character chara : characters) {
            System.out.println(chara);
        }
        */

        /*
        for(int m = 0; m < 8; m++) {
            System.out.println("Your random character is " + randomCharacter().getName());
        }
         */
        System.out.println("===========================");
        System.out.println("Random Abyss Team Generator");
        System.out.println("===========================");
        System.out.println(characters.size() + " available characters from " + data + ".");
        System.out.println();

        System.out.println("=========Side one:=========");
        for(Character chara : abyssTeam1) {
            System.out.println(chara);
        }
        System.out.println("---------------------------");
        System.out.print("Resonances: ");
        for(Resonance r1 : generateElementalResonance(abyssTeam1)) {
            System.out.print(r1.toString(r1) + ", ");
        }
        System.out.println();
        System.out.print("Reactions: ");
        for(String s1 : generateReactions(abyssTeam1)) {
            System.out.print(s1 + ", ");
        }
        System.out.println();
        System.out.println("---------------------------");

        System.out.println();
        System.out.println("=========Side two:=========");
        for(Character chara : abyssTeam2) {
            System.out.println(chara);
        }
        System.out.println("---------------------------");
        System.out.print("Resonances: ");
        for(Resonance r2 : generateElementalResonance(abyssTeam2)) {
            System.out.print(r2.toString(r2) + ", ");
        }
        System.out.println();
        System.out.print("Reactions: ");
        for(String s2 : generateReactions(abyssTeam2)) {
            System.out.print(s2 + ", ");
        }
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        /*
        ArrayList<String> testCharasList = new ArrayList<>();
        testCharasList.add("Jean,Anemo,Sword,5");
        testCharasList.add("Kaedehara Kazuha,Anemo,Sword,5");
        testCharasList.add("Traveler,Anemo,Sword,5");
        testCharasList.add("Xiao,Anemo,Polearm,5");

        Character[] testCharaTeam = new Character[4];
        for(int p = 0; p < 4; p++) {
            testCharaTeam[p] = new Character(testCharasList.get(p));
        }

        ArrayList<Resonance> testResonances = generateElementalResonance(testCharaTeam);
        for(Resonance tR : testResonances) {
            System.out.println(tR);
        }

         */

        /*
        Character[] longCharaArray = new Character[25];
        ArrayList<Character> seperateCharaList = this.characters;

        randomTeamGenerator(seperateCharaList, longCharaArray);

        for(Character c : longCharaArray) {
            System.out.println(c);
        }

         */
    }

    /**
     * sets the Characters list to a new list from file
     * @param data formatted csv
     */
    public void setCharacters(String data) {
        try {
            characters = this.readDataFromFile(data);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.randomTeamGenerator();
    }

    /**
     * sets the Characters list to a new list from an existing ArrayList
     * @param list ArrayList of Characters
     */
    public void setCharacters(ArrayList<Character> list) {
        characters = list;
        this.randomTeamGenerator();
    }

    /**
     * Run your program here
     * @param args Yeah, don't use this, please.
     */
    public static void main(String[] args){

        AbyssTeamApp app = new AbyssTeamApp("data/PyrrhicCharacterList.txt");
        app.run();
        app.setCharacters("data/SilvaCharacterList.txt");
        app.run();
        app.setCharacters("data/CharacterList.txt");
        app.run();

    }

}
