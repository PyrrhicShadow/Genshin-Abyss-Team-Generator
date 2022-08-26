package abyssTeamGen;

import java.util.HashMap;

public enum Resonance {
    FERVENT_FLAMES, SOOTHING_WATER, HIGH_VOLTAGE,  SHATTERING_ICE, IMPETUOUS_WINDS, ENDURING_ROCK, SPRAWLING_GREENERY, PROTECTIVE_CANOPY, NO_RESONANCE;

    public static String getDescription(Resonance r) {
        return switch (r) {
            case FERVENT_FLAMES -> "Affected by Cryo for 40% less time. Increases ATK by 25%.";
            case SOOTHING_WATER -> "Affected by Pyro for 40% less time. Increases incoming healing by 30%.";
            case HIGH_VOLTAGE -> "Affected by Hydro for 40% less time. Superconduct, Overloaded, and Electro-Charged have a 100% chance to generate an Electro Elemental Particle (CD: 5s).";
            case SHATTERING_ICE -> "Affected by Electro for 40% less time. Increases CRIT Rate against enemies that are Frozen or affected by Cryo by 15%.";
            case IMPETUOUS_WINDS -> "Decreases Stamina Consumption by 15%. Increases Movement SPD by 10%. Shortens Skill CD by 5%.";
            case ENDURING_ROCK -> "Increases shield strength by 15%. Additionally, characters protected by a shield will have the following special characteristics: DMG dealt increased by 15%, dealing DMG to enemies will decrease their Geo RES by 20% for 15s.";
            case SPRAWLING_GREENERY -> "After triggering Burning, Quicken, or Bloom reactions, all nearby party members gain 30 EM for 6s. After triggering Aggravate, Spread, Hyperbloom, or Burgeon reactions, all nearby party memebers gain 20 EM for 6s. The duration of the aformentioned effects will be counted independently.";
            case PROTECTIVE_CANOPY -> "All Elemental RES +15%, Physical RES +15%.";
            default -> "Unknown resonance.";
        };
    }

    public String toString(Resonance r) {
        return switch (r) {
            case FERVENT_FLAMES -> "Fervent Flames";
            case SOOTHING_WATER -> "Soothing Water";
            case HIGH_VOLTAGE -> "High Voltage";
            case SHATTERING_ICE -> "Shattering Ice";
            case IMPETUOUS_WINDS -> "Impetuous Winds";
            case ENDURING_ROCK -> "Enduring Rock";
            case SPRAWLING_GREENERY -> "Sprawling Greenery";
            case PROTECTIVE_CANOPY -> "Protective Canopy";
            case NO_RESONANCE -> "No resonance";
            default -> "Unknown resonance";
        };
    }

}
