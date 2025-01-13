package Game;
import java.util.Random;
import java.util.Arrays;

public class Shop {

    private Random random = new Random();

    private int shopItems[] = new int[6];
    private int item;

    

    public void generateItems(){
        for (int i = 0; i < shopItems.length; i++){
            item = random.nextInt(5);
            shopItems[i] = item;
            System.out.println(item);
        }
    }
    

    public static void main(String[] args) {

        Utility.printInDoubleBox("Welocome to the Shop!");

        Shop shop = new Shop();
        shop.generateItems();

    }
}