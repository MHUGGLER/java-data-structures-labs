import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void combineItems(String name1, String name2, String newName) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) && !found1) {
                iter.remove();
                found1 = true;
            } else if (current.getName().equals(name2) && !found2) {
                iter.remove();
                found2 = true;
            }
        }

        if (found1 && found2) {
            items.add(new Item(newName));
        }
    }
}