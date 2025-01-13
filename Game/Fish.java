package Game;
import java.util.Random;

public class Fish extends Item {
    static Random rand = new Random();
    public Fish(Rarity rarity,ItemClass itemClass, String name, int healAmount, int sellAmount) {
        super(rarity, itemClass, name, sellAmount);
        this.setHealAmount(healAmount);
    }

    public static void catchFish(Inventory inv) {
        Fish caughtFish = new Fish(Rarity.COMMON,ItemClass.CONSUMABLE, "Empty", 5, 1);
        int randomNumber = rand.nextInt(100);

        Utility.clearScreen();

        if (randomNumber < 50) {
            caughtFish = new Fish(Rarity.COMMON,ItemClass.CONSUMABLE, "Cod", 5, 1);
            inv.addItem(caughtFish);
            System.out.println("");
            System.out.println("<°))))><");
            System.out.println("");
        }

        else if (randomNumber < 75) {
            caughtFish = new Fish(Rarity.UNCOMMON,ItemClass.CONSUMABLE, "Salmon", 10, 3);
            inv.addItem(caughtFish);

            System.out.println("");
            System.out.println("           /\"*._         _");
            System.out.println("      .-*'`    `*-.._.-'/");
            System.out.println("    < * ))     ,       ( ");
            System.out.println("      `*-._`._(__.--*\"`.\\");
            System.out.println("");
        }

        else if (randomNumber < 90) {
            caughtFish = new Fish(Rarity.RARE,ItemClass.CONSUMABLE, "Pufferfish", 20, 5);
            inv.addItem(caughtFish);
            System.out.println("");
            System.out.println("       _");
            System.out.println("      /_|");
            System.out.println("     ('_)<|");
            System.out.println("      \\_|  ");
            System.out.println("");
        }
        else if (randomNumber < 98) {
            caughtFish = new Fish(Rarity.EPIC,ItemClass.CONSUMABLE, "Tropical Fish", 30, 10);
            inv.addItem(caughtFish);
            System.out.println("");
            System.out.println("  ;,//;,    ,;/");
            System.out.println(" o:::::::;;///");
            System.out.println(">::::::::;;\\\\\\");
            System.out.println("  ''\\\\\\\\\\\'\" ';\\");
            System.out.println("");
        }

        else if (randomNumber <= 100) {
            caughtFish = new Fish(Rarity.LEGENDARY,ItemClass.CONSUMABLE, "Catfish", 100 ,20);
            inv.addItem(caughtFish);
            System.out.println("");
            System.out.println("  ^~^  ,");
            System.out.println(" ('Y') )");
            System.out.println(" /   \\/ ");
            System.out.println("(\\|||/) ");
            System.out.println("");
        }

    System.out.println("You caught a " + caughtFish);
    }

}
