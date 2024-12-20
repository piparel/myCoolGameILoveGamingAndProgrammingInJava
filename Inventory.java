import java.util.Scanner;

// TODO: Code comments for better grade 

public class Inventory {
    private Item[] inventoryItems = new Item[8];
    private int inventoryLength = inventoryItems.length;
    private boolean isFull = false;
    private final Scanner scanner = new Scanner(System.in);


    public void addItem(int index, Item item) {
        if (inventoryItems[index] == null) {
            inventoryItems[index] = item;
        }
        checkIfFull();
    }

    public void addItem(Item item) {
        for (int i = 0; i<inventoryLength; i++) {
            if (inventoryItems[i] == null) {
                addItem(i, item);
                break;
            }
        }
    }

    public void removeItem(int index) {
        if (inventoryItems[index] != null) {
            inventoryItems[index] = null;
        }
        else {
            System.out.println("Invalid choice at removeitem");
        }
        checkIfFull();
    }

    public boolean checkIfFull() {
        for (int i = 0; i < inventoryLength; i++) {
            if (inventoryItems[i] == null) {
               isFull = false; 
               return isFull;
            }
        }
        isFull = true;
        return isFull;
    }

    public void openInventory() {
        String userString = "";

        while (true) {
            System.out.println(this);
            System.out.println("");
            System.out.println("press [q] to close your inventory");
            System.out.println("press [d] to drop an item");
            userString = scanner.nextLine();

            switch (userString) {
                case "q":
                    return;

                case "d":
                    System.out.println("Enter the index of the item you would like to drop: ");
                    int index = scanner.nextInt(); 
                    scanner.nextLine();
                    removeItem(index);
                    break;

                default: 
                    System.out.println("invalid choice at OpenInventory");
            }

        }

    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < inventoryLength; i++) {
            if (inventoryItems[i] == null) {
                returnString = returnString + "[" + i + "]"+ " [     ], ";
            }
            else {
                returnString = returnString + "[" + i + "]" + " " + inventoryItems[i].toString() + ", ";
            }
        }

        return returnString;
    }
}
