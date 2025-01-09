import java.util.Scanner;

// TODO: Code comments for better grade 

public class Inventory {
    private Item[] inventoryItems = new Item[8];
    private int inventoryLength = inventoryItems.length;
    private Item[] equipmentItems = new Item[5];
    private int equipmentLength = equipmentItems.length;
    private boolean isEquipmentOpen = false;
    
    private boolean isFull = false;
    private final Scanner scanner = new Scanner(System.in);
    private Character player; 

    public void belongsTo(Character player) {
        this.player = player;
    }

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
            System.out.println(this.toString(isEquipmentOpen));
            System.out.println("");
            System.out.println("press [q] to close your inventory");
            System.out.println("press [d] to drop an item");
            System.out.println("press [e] to use/equip an Item");
            System.out.println("press [i] to open your equipment");
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


                case "e":
                    System.out.println("Enter the index of the item you would like to use/equip");
                    index = scanner.nextInt();
                    if (inventoryItems[index].getItemClass() == ItemClass.CONSUMABLE) {
                        eat(index);
                    }
                    else if (inventoryItems[index] instanceof Equipment){
                        equip(index);
                    }
                    return;

                case "i":
                    isEquipmentOpen = true;
                    System.out.println(this.toString(isEquipmentOpen));
                    index = scanner.nextInt();
                    return;
                    

                default: 
                    System.out.println("invalid choice at OpenInventory");
            }

        }

    }

    public void eat(int index) {
        System.out.println("you ate the " + inventoryItems[index] + " and gained " + inventoryItems[index].getHealAmount() + " HP");
        player.increaseHealth(inventoryItems[index].getHealAmount());
        removeItem(index);
    }
    public void equip(int index){
        
        if (inventoryItems[index].getItemClass() == ItemClass.WEAPON){
            equipmentItems[0] = inventoryItems[index];
            System.out.println("you equipped " + inventoryItems[index]);
        }
        else if (inventoryItems[index].getItemClass() == ItemClass.ARMOR){
            equipmentItems[1] = inventoryItems[index];
            System.out.println("you equipped " + inventoryItems[index]);
        }

    }
        

    public String toString(boolean isEquipmentOpen) {
        String returnString = "";

        if (isEquipmentOpen){
            for (int i = 0; i < equipmentLength; i++) {
                if (equipmentItems[i] == null) {
                    returnString = returnString + "[" + i + "]"+ " [     ], ";
                }
                else {
                    returnString = returnString + "[" + i + "]" + " " + equipmentItems[i].toString() + ", ";
                }
            }
        }
        else{
            for (int i = 0; i < inventoryLength; i++) {
                if (inventoryItems[i] == null) {
                    returnString = returnString + "[" + i + "]"+ " [     ], ";
                }
                else {
                    returnString = returnString + "[" + i + "]" + " " + inventoryItems[i].toString() + ", ";
                }
            }
        }
        return returnString;
    }
}
