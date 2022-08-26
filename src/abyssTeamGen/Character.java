package abyssTeamGen;

public class Character implements Comparable<Character> {
    private String name;
    private Element vision;
    private Weapon weapon;
    private int rarity;
    private Teyvat region;

    /**
     *
     * @param name String name of character used in UI
     * @param vision Element of character's vision
     * @param weapon Weapon of character's weapon
     * @param rarity Star rarity of character
     * @param region Teyvat of character's vision, Outlander for the Traveler and collab characters
     */
    public Character(String name, Element vision, Weapon weapon, int rarity, Teyvat region) {
        this.name = name;
        this.vision = vision;
        this.weapon = weapon;
        this.rarity = rarity;
        this.region = region;
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
        region = Teyvat.valueOf(subStrings[4].toUpperCase());
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

    public Teyvat getRegion() {
        return region;
    }

    /**
     * Returns a human-readable String of the character's info
     * @return ex: Eula: 5-star cryo claymore user from Mondstadt
     */
    public String toString() {
        return name + ": " + rarity + "-star " + vision.toString() + " " + weapon.toString() + " user - " + region.toString();
    }

    @Override
    public boolean equals(Object obj){
        Character other = (Character)obj;
        return this.compareTo(other) == 0;
    }

    public int compareTo(Character other){
        return this.name.compareTo(other.name);
    }
}
