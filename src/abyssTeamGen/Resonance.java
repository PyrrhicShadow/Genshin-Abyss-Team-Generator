package abyssTeamGen;

import java.util.HashMap;

public enum Resonance {
    FERVENT_FLAMES, SOOTHING_WATER, HIGH_VOLTAGE,  SHATTERING_ICE, IMPETUOUS_WINDS, ENDURING_ROCK, PROTECTIVE_CANOPY, NO_RESONANCE;

    public static String getDescription(Resonance r) {
        switch (r) {
            case FERVENT_FLAMES:
                return "Affected by Cryo for 40% less time. Increases ATK by 25%.";
            case SOOTHING_WATER:
                return "Affected by Pyro for 40% less time. Increases incoming healing by 30%.";
            case HIGH_VOLTAGE:
                return "Affected by Hydro for 40% less time. Superconduct, Overloaded, and Electro-Charged have a 100% chance to generate an Electro Elemental Particle (CD: 5s).";
            case SHATTERING_ICE:
                return "Affected by Electro for 40% less time. Increases CRIT Rate against enemies that are Frozen or affected by Cryo by 15%.";
            case IMPETUOUS_WINDS:
                return "Decreases Stamina Consumption by 15%. Increases Movement SPD by 10%. Shortens Skill CD by 5%.";
            case ENDURING_ROCK:
                return "Increases shield strength by 15%. Additionally, characters protected by a shield will have the following special characteristics: DMG dealt increased by 15%, dealing DMG to enemies will decrease their Geo RES by 20% for 15s.";
            case PROTECTIVE_CANOPY:
                return"All Elemental RES +15%, Physical RES +15%.";
            default:
                return"Unknown resonance.";

        }
    }

    public String toString(Resonance r) {
        switch (r) {
            case FERVENT_FLAMES:
                return "Fervent Flames";
            case SOOTHING_WATER:
                return "Soothing Water";
            case HIGH_VOLTAGE:
                return "High Voltage";
            case SHATTERING_ICE:
                return "Shattering Ice";
            case IMPETUOUS_WINDS:
                return "Impetuous Winds";
            case ENDURING_ROCK:
                return "Enduring Rock";
            case PROTECTIVE_CANOPY:
                return "Protective Canopy";
            case NO_RESONANCE:
                return "No resonance";
            default:
                return "Unknown resonance.";
        }
    }

}
