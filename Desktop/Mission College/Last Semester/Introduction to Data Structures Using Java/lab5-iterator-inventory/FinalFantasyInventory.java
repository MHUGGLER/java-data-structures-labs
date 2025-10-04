public class FinalFantasyInventory {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItem(new Item("Sword"));
        inv.addItem(new Item("Shield"));
        inv.addItem(new Item("Potion"));

        System.out.println("Initial Inventory:");
        inv.display();

        inv.combineItems("Sword", "Shield", "Excalibur");

        System.out.println("\nFinal Inventory:");
        inv.display();
    }
}