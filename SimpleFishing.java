import java.util.Scanner;

public class SimpleFishing {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Inventory inv = new Inventory(); 

    System.out.println("Welcome to this cool Fishing Simulator!!!");
    System.out.println("-----------------------------------------");
    System.out.println();

    String userInput = "";

    while (true) {
        System.out.println("Would you like to [f]ish, [i]nventory or [q]uit?");
        userInput = scanner.nextLine();
        if (userInput.equals("f")) {
            Fish.catchFish(inv);
        }

        else if (userInput.equals("i")) {
            inv.openInventory();
        }

        else if (userInput.equals("q")) {
            return;
        }

    } 
}
}