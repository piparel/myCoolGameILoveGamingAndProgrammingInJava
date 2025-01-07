public class testInventory {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Fish fish = new Fish(Rarity.LEGENDARY, "Dragonfish", 100);
        inv.addItem(0, fish);
        
        inv.openInventory();

        inv.removeItem(0);

        inv.openInventory();


        }
    }

