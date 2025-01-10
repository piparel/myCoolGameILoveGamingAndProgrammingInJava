// TODO: Code Comments

public class Item {
    private Rarity rarity;
    private ItemClass itemClass;
    private String name;
    private int healAmount;
    private int sellAmount;

    public Item() {
        this(Rarity.COMMON, ItemClass.WEAPON, "DefaultItem", 0);
    }

    public Item(Rarity rarity,ItemClass itemClass, String name, int sellAmount) {
        setRarity(rarity);
        setItemClass(itemClass);
        setName(name);
        setSellAmount(sellAmount);
    }

    public void setHealAmount(int num) {
        this.healAmount = num;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    public void setItemClass(ItemClass itemClass){
        this.itemClass = itemClass;
    }

    public ItemClass getItemClass(){
        return this.itemClass;
    }

    public void setSellAmount(int num){
        this.sellAmount = num;
    }

    public int getSellAmount(){
        return this.sellAmount;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
       return this.rarity + " " + this.name;  
    }
}