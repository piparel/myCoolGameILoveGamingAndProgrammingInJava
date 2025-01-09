enum ItemClass {
    WEAPON,
    ARMOR,
    RING,
    BOOTS,
    ACCESSORY,
    CONSUMABLE
    ;

    public String toString() {
        switch (this) {
            case WEAPON:
                return "Weapon";

            case ARMOR:
                return "Armor";
            
            case RING:
                return "Ring";
                
            case BOOTS:
                return "Boots";
                
            case ACCESSORY:
                return "Accessory";
            
            case CONSUMABLE:
                return "Consumable";

            default:
                return "INVALID CLASS";
        }
    }
}

