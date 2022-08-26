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
        else if(trigger == DENDRO) {
            if(aura == PYRO) {
                return "Burning";
            }
            else if(aura == HYDRO) {
                return "Bloom";
            }

            else if(aura == ELECTRO) {
                return "Quicken (Spread)";
            }
            else {
                return "No reaction";
            }
        }
        else if(trigger == GEO) {
            if(aura == ANEMO || aura == DENDRO) {
                return "No reaction";
            }
            else if (aura == PYRO){
                return "Crystalize (Pyro)";
            }
            else if (aura == CRYO){
                return "Crystalize (Cryo)";
            }
            else if (aura == HYDRO){
                return "Crystalize (Hydro)";
            }
            else if (aura == ELECTRO){
                return "Crystalize (Electro)";
            }
        }
        else if(trigger == ANEMO) {
            if (aura == GEO || aura == DENDRO) {
                return "No reaction";
            }
            else if (aura == PYRO){
                return "Swirl (Pyro)";
            }
            else if (aura == CRYO){
                return "Swirl (Cryo)";
            }
            else if (aura == HYDRO){
                return "Swirl (Hydro)";
            }
            else if (aura == ELECTRO){
                return "Swirl (Electro)";
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
            else if(aura == DENDRO) {
                return "Burning";
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
            else if (aura == DENDRO) {
                return "Bloom";
            }
            else {
                return "No reaction";
            }
        }
        else if(trigger == ELECTRO) {
            if (aura == PYRO) {
                return "Overloaded";
            }
            else if(aura == CRYO) {
                return "Superconduct";
            }
            else if(aura == HYDRO) {
                return "Electrocharged";
            }
            else if (aura == DENDRO) {
                return "Quicken (Aggrivate)";
            }
        }
        return "No reaction";
    }

    private String getBloomType(Element coreTrigger) {
         if (coreTrigger == ELECTRO) {
             return "Bloom (Hyperbloom)";
         }
         else if (coreTrigger == PYRO) {
             return "Bloom (Burgeon)";
         }
        else {
            return "Bloom";
        }
    }

    public String toString() {
         return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
