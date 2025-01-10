public class testInventory {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Fish fish = new Fish(Rarity.LEGENDARY,ItemClass.CONSUMABLE, "Dragonfish", 100, 10);
        Equipment knife = new Equipment(Rarity.EPIC, ItemClass.WEAPON, "English Street Knife", 9999);
        Equipment bigPufferjacket = new Equipment(Rarity.LEGENDARY, ItemClass.ARMOR,"Jacket of a true British Geezer", 9999999);
        inv.addItem(0, fish);
        inv.addItem(1, knife);
        inv.addItem(2, bigPufferjacket);
        
        System.out.println(knife.getName());
        
        inv.openInventory();
    }
}

