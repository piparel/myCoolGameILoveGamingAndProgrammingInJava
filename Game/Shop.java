package Game;
import java.util.Random;
import java.util.Arrays;

public class Shop {

    private Random random = new Random();

    private Equipment[] shopItems = new Equipment[5];
    private int item;

    

    public void openShop(){
        for (int i = 0; i < shopItems.length; i++){
            System.out.println("Price: " + shopItems[i].getSellAmount() + " " + shopItems[i]);
        }
    }


    public void buy(Character player, int index) {
        if (player.getCoins() >= shopItems[index].getSellAmount()) {
            player.addItem(shopItems[index]);
            shopItems[index] = null;
        }

        else {
            System.out.println("Poor");
        }
    }

    

    public static void main(String[] args) {
        Shop shop = new Shop();
        Character testCharacter = new Character(100, 5, 40, 0, 0, 10, 0);
        testCharacter.setCoins(1000000000);
        Inventory inv = new Inventory();
        inv.belongsTo(testCharacter);


        Utility.printInDoubleBox("Welocome to the Shop!");
        Equipment sword = (Equipment) Equipment.IceTeaLemonSword();

        shop.shopItems[0] = sword;
        shop.shopItems[1] = sword;
        shop.shopItems[2] = sword;
        shop.shopItems[3] = sword;
        shop.shopItems[4] = sword;

        shop.openShop();
        shop.buy(testCharacter, 0);
        testCharacter.openInventory();

    }
}