import java.util.Random;


public class Producer extends Thread {
    final Buffer buffer;
    final String name;

    public Producer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Random random = new Random(System.currentTimeMillis());
                final RandomString randomString = new RandomString(4);
                String name = randomString.nextString();
                final Item item = new Item(name);
                buffer.publish(item);
                System.out.println(this.name + " produced " + item);

                sleep(random.nextInt(8) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
