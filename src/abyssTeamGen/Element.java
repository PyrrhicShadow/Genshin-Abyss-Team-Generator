package abyssTeamGen;

public enum Element {
    PYRO, CRYO, HYDRO, ELECTRO, ANEMO, GEO, DENDRO;

    /**
     * Returns a String description of the elemental reaction caused by the apllication of the trigger element on an target affected by the aura element
     * @param aura The aura element on target
     * @param trigger The trigger element applied
     * @return Name (and direction if applicable) of reaction
     */
     public static String getReaction(Element aura, Element trigger) {
        if(trigger == aura || aura == GEO || aura == ANEMO) {
            return "No reaction";
        }
        else if(aura == DENDRO || trigger == DENDRO) {
            if(trigger == PYRO || aura == PYRO) {
                return "Burning";
            }
        }
        else if(trigger == GEO) {
            if(aura == ANEMO) {
                return "No reaction";
            }
            else {
                return "Crystalize";
            }
        }
        else if(trigger == ANEMO) {
            if (aura == GEO) {
                return "No reaction";
            }
            else {
                return "Swirl";
            }
        }
        else if(trigger == PYRO) {
            if(aura == CRYO) {
                return "Melt (forward)";
            }
            else if(aura == HYDRO) {
                return "Vaporize (reverse)";
            }
            else if(aura == ELECTRO) {
                return "Overloaded";
            }
            else{
                return "No reaction";
            }
        }
        else if(trigger == CRYO) {
            if (aura == PYRO) {
                return "Melt (reverse)";
            }
            else if(aura == HYDRO) {
                return "Freeze";
            }
            else if(aura == ELECTRO) {
                return "Superconduct";
            }
            else {
                return "No reaction";
            }
        }
        else if(trigger == HYDRO) {
            if (aura == PYRO) {
                return "Vaporize (forward)";
            }
            else if(aura == CRYO) {
                return "Freeze";
            }
            else if(aura == ELECTRO) {
                return "Electrocharged";
            }
            else {
                return "No reaction";
            }
        }
        else if(trigger == ELECTRO) {
            if (aura == PYRO) {
                return "Overconduct";
            }
            else if(trigger == CRYO) {
                return "Superconduct";
            }
            else if(trigger == HYDRO) {
                return "Electrocharged";
            }
        }
        return "No reaction";
    }

    public String toString() {
         return super.toString().toLowerCase();
    }
}
