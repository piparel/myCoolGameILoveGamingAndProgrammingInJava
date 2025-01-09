enum Rarity {
    COMMON,
    UNCOMMON,
    RARE,
    EPIC,
    LEGENDARY,
    ;

    public String toString() {
        switch (this) {
            case COMMON:
                return "Common";

            case UNCOMMON:
                return "Uncommon";
            
            case RARE:
                return "Rare";
                
            case EPIC:
                return "Epic";
                
            case LEGENDARY:
                return "Legendary";

            default:
                return "INVALID RARITY";
        }
    }
}