package Game;
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
            Utility.clearScreen();
            System.out.println(this.toString(isEquipmentOpen));
            System.out.println("");
            System.out.println("press [q] to close your inventory");
            System.out.println("press [d] to drop an item");
            System.out.println("press [e] to use/equip an Item");
            System.out.println("press [i] to open your equipment");
            userString = scanner.nextLine();

            switch (userString) {
                case "q":
                    Utility.clearScreen();
                    return;

                case "d":
                    Utility.clearScreen();
                    System.out.println(this.toString(isEquipmentOpen));
                    System.out.println("Enter the index of the item you would like to drop: ");
                    int index = scanner.nextInt(); 
                    scanner.nextLine();
                    removeItem(index);
                    break;


                case "e":
                    Utility.clearScreen();
                    System.out.println(this.toString(isEquipmentOpen));
                    System.out.println("Enter the index of the item you would like to use/equip");
                    index = scanner.nextInt();
                    if (inventoryItems[index].getItemClass() == ItemClass.CONSUMABLE) {
                        Utility.clearScreen();
                        eat(index);
                    }
                    else if (inventoryItems[index] instanceof Equipment){
                        Utility.clearScreen();
                        equip(index);
                    }
                    break;

                case "i":
                    Utility.clearScreen();
                    isEquipmentOpen = true;
                    System.out.println(this.toString(isEquipmentOpen));
                    System.out.println("press [q] to close your equipment");
                    System.out.println("press [e] to unequip an item");
                    userString = scanner.nextLine();
                    switch (userString) {
                        case "q":
                            isEquipmentOpen = false;
                            break;
                        case "e":
                        Utility.clearScreen();
                        System.out.println(this.toString(isEquipmentOpen));
                        System.out.println("Enter the index of the item you would like to unequip");
                        index = scanner.nextInt();
                        unequip(index);
                        isEquipmentOpen = false;
                    }
                    break;

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
         switch(inventoryItems[index].getItemClass()){
            case WEAPON:
                equipmentItems[0] = inventoryItems[index];
                break;
            case ARMOR:
                equipmentItems[1] = inventoryItems[index];
                break;
            case RING:
                equipmentItems[2] = inventoryItems[index];
                break;
            case BOOTS:
                equipmentItems[3] = inventoryItems[index];
                break;
            case ACCESSORY:
                equipmentItems[4] = inventoryItems[index];
                break;
            case CONSUMABLE:
                System.out.println("Can't equip that");
                break;
        }
        System.out.println("you equipped " + inventoryItems[index]);
        removeItem(index);
    }   

    public void unequip(int index){
        if (checkIfFull() == false){
            if (equipmentItems[index] != null) {
                addItem(equipmentItems[index]);
                equipmentItems[index] = null;
            }
            else {
                System.out.println("Invalid choice at removeitem");
            }
        }
        else{
            System.out.println("your inventory is full!");
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
