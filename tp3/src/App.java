public class App {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        for (int i = 0; i < 5; i++) {
            final Producer producer = new Producer(buffer, "Producer" + i);
            producer.start();
        }

        for (int i = 0; i < 15; i++) {
            final Consumer consumer = new Consumer(buffer, "Consumer" + i);
            consumer.start();
        }
    }
}
