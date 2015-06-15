import java.util.ArrayList;
import java.util.List;


public class Buffer {
    private final List<Item> items;
    private final int size;

    public Buffer(int size) {
        this.items = new ArrayList<Item>();
        this.size = size;
    }

    public synchronized void publish(Item item) throws InterruptedException {
        while (items.size() >= size) {
            System.out.println(" - wait - ");
            wait();
        }

        items.add(item);
        notifyAll();
    }

    public synchronized Item consume() throws InterruptedException {
        while (items.isEmpty()) {
            System.out.println(" - wait - ");
            wait();
        }

        final Item item = items.remove(0);
        notifyAll();

        return item;
    }
}
