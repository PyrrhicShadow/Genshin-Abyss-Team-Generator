package abyssTeamGen;

public enum Region {
    OTHER, MONDSTADT, LIYUE, INAZUMA, SUMERU, FONTAINE, NATLAN, SNEZHNAYA;

    @Override
    public String toString() {
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
