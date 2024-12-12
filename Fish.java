import java.util.Random;

public class Fish extends Item {
    static Random rand = new Random();
    public Fish(Rarity rarity, String name) {
        super(rarity, name);
    }

    public static void catchFish(Inventory inv) {
        Fish caughtFish = new Fish(Rarity.COMMON, "Empty");
        int randomNumber = rand.nextInt(0, 100);
        if (randomNumber < 50) {
            caughtFish = new Fish(Rarity.COMMON, "Cod");
            inv.addItem(caughtFish);
        }

        else if (randomNumber < 75) {
            caughtFish = new Fish(Rarity.UNCOMMON, "Salmon");
            inv.addItem(caughtFish);
        }

        else if (randomNumber < 90) {
            caughtFish = new Fish(Rarity.RARE, "Pufferfish");
            inv.addItem(caughtFish);
        }
        else if (randomNumber < 98) {
            caughtFish = new Fish(Rarity.EPIC, "Tropical Fish");
            inv.addItem(caughtFish);
        }

        else if (randomNumber < 100) {
            caughtFish = new Fish(Rarity.LEGENDARY, "Catfish");
            inv.addItem(caughtFish);
        }

    System.out.println("You caught a " + caughtFish);
    }
}
