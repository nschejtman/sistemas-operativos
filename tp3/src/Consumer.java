import java.util.Random;


public class Consumer extends Thread {
    final Buffer buffer;
    final String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Item item = buffer.consume();
                System.out.println(this.name + " consumed " + item);

                final Random random = new Random(System.currentTimeMillis());
                sleep(random.nextInt(8) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
