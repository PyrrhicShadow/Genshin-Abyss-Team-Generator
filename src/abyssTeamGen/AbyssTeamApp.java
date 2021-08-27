package abyssTeamGen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class AbyssTeamApp extends CharacterIO {

    private ArrayList<Character> characters;
    private Character[] abyssTeam1;
    private Character[] abyssTeam2;
    private static final int ABYSS_TEAM_SIZE = 4;
    private HashSet<String> reactions1;
    private HashSet<String> reactions2;

    /**
     *
     * @param characters
     */
    public AbyssTeamApp(ArrayList<Character> characters) {
        this.characters = characters;
        abyssTeam1 = new Character[ABYSS_TEAM_SIZE];
        abyssTeam2 = new Character[ABYSS_TEAM_SIZE];
        reactions1 = new HashSet<>();
        reactions2 = new HashSet<>();
        this.randomTeamGenerator();


    }

    /**
     *
     * @param data
     */
    public AbyssTeamApp(String data) {
        try {
            characters = this.readDataFromFile(data);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        abyssTeam1 = new Character[ABYSS_TEAM_SIZE];
        abyssTeam2 = new Character[ABYSS_TEAM_SIZE];
        reactions1 = new HashSet<>();
        reactions2 = new HashSet<>();
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
                System.out.println("Character duplicate skipped");
            }
        }
        for(int w = 0; w < ABYSS_TEAM_SIZE; w++) {
            abyssTeam1[w] = tempAbyssTeam.get(w);
            abyssTeam2[w] = tempAbyssTeam.get(w + ABYSS_TEAM_SIZE);
        }
        this.generateReactions();

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
     * Getter for Abyssal team reaction possibilities for team 1
     * @return HashSet of Strings containing all the possible reactions producible by given Abyssal team
     */
    public HashSet<String> getReactions1(){
        return reactions1;
    }

    /**
     * Getter for Abyssal team reaction possibilities for team 2
     * @return HashSet of Strings containing all the possible reactions producible by given Abyssal team
     */
    public HashSet<String> getReactions2(){
        return reactions2;
    }

    /**
     * Generates all possible elemental combinations for each Abyssal team
     * Does not generate names of reactions or deal with mono-elemental possibilities
     */
    public void generateReactions() {
        ArrayList<Tuple<Element>> combinations = new ArrayList<>();
        for(Character chara1 : abyssTeam1) {
            for(Character chara2 : abyssTeam1) {
                if(!chara1.equals(chara2)) {
                    combinations.add(new Tuple<Element>(chara1.getVision(), chara2.getVision()));
                }
            }
        }

        for(Tuple<Element> comb : combinations) {
            reactions1.add(Element.getReaction(comb.getOne(), comb.getTwo()));
        }


        for(Character chara1 : abyssTeam2) {
            for(Character chara2 : abyssTeam2) {
                if(!chara1.equals(chara2)) {
                    combinations.add(new Tuple<Element>(chara1.getVision(), chara2.getVision()));
                }
            }
        }
        for(Tuple<Element> comb : combinations) {
            reactions2.add(Element.getReaction(comb.getOne(), comb.getTwo()));
        }
    }

    public Character[] getAbyssTeam1() {
        return abyssTeam1;
    }

    public Character[] getAbyssTeam2() {
        return abyssTeam2;
    }

    /**
     * The messy body of the program that contains the business logic
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


        System.out.println("Your random abyss teams are:");
        System.out.println("=====Side one:=====");
        for(Character chara : abyssTeam1) {
            System.out.println(chara);
        }
        System.out.println();
        System.out.println("Your possible side one reactions are: ");
        for(String s1 : reactions1) {
            System.out.println(" " + s1);
        }
        System.out.println();
        System.out.println("=====Side two:=====");
        for(Character chara : abyssTeam2) {
            System.out.println(chara);
        }
        System.out.println();
        System.out.println("Your possible side two reactions are");
        for(String s2 : reactions2) {
            System.out.println(" " + s2);
        }


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
     * Run your program here
     * @param args Yeah, don't use this please.
     */
    public static void main(String[] args){

        AbyssTeamApp app = new AbyssTeamApp("data/CharacterList.txt");
        app.run();

    }

}
