package Game;
public class Equipment extends Item {
    private int strength;

    public Equipment(Rarity rarity, ItemClass itemClass, String name, int sellAmount, int strength) {
        super(rarity, itemClass, name, sellAmount);
        this.strength = strength;
    }
        
    public Equipment(Rarity rarity, ItemClass itemClass, String name, int sellAmount) {
        super(rarity, itemClass, name, sellAmount);
    }
    public static Item IceTeaLemonSword() {
    return new Equipment(

            Rarity.LEGENDARY, 
            ItemClass.WEAPON,
            "Ice Tea Lemon Sword",
            696969,
            100
        );

    }  
}

