package abyssTeamGen;

public class Character implements Comparable<Character> {
    private String name;
    private Element vision;
    private Weapon weapon;
    private int rarity;

    /**
     *
     * @param name String name of character used in UI
     * @param vision Element of character's vision
     * @param weapon Weapon of character's weapon
     * @param rarity Star rarity of character
     */
    public Character(String name, Element vision, Weapon weapon, int rarity) {
        this.name = name;
        this.vision = vision;
        this.weapon = weapon;
        this.rarity = rarity;
    }

    /**
     * Takes a string input and converts it into a Character
     * @param input takes a single line of a formatted CSV
     */
    public Character(String input) {
        String[] subStrings = input.split(",");
        name = subStrings[0];
        vision = Element.valueOf(subStrings[1].toUpperCase());
        weapon = Weapon.valueOf(subStrings[2].toUpperCase());
        rarity = Integer.parseInt(subStrings[3]);
        }

    public String getName() {
        return name;
    }

    public Element getVision() {
        return vision;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getRarity(){
        return rarity;
    }

    public String toString(){
        return name + ": " + rarity + "-star " + vision.toString() + " " + weapon.toString() + " user";
    }

    public boolean equals(Object obj){
        Character other = (Character)obj;
        if(this.compareTo(other) == 0) {
            return true;
        }
        return false;
    }

    public int compareTo(Character other){
        return this.name.compareTo(other.name);
    }
}
