package abyssTeamGen;

public enum Weapon {
    BOW, CATALYST, SWORD, POLEARM, CLAYMORE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
