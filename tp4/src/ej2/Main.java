package ej2;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final BarberShop barberShop = new BarberShop(10);
        final long maxTime = System.currentTimeMillis() + 60000l;
        final Barber barber = new Barber(barberShop);
        barber.start();
        while (System.currentTimeMillis() < maxTime) {
            final Customer customer = new Customer(barberShop);
            customer.start();
            final Random random = new Random(System.currentTimeMillis());
            Thread.sleep(random.nextInt(800));
        }
    }
}
