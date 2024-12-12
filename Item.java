// TODO: Code Comments

public class Item {
    private Rarity rarity;
    private String name;

    public Item() {
        this(Rarity.COMMON, "DefaultItem");
    }

    public Item(Rarity rarity, String name) {
        setRarity(rarity);
        setName(name);
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
       return this.rarity + " " + this.name;  
    }
}