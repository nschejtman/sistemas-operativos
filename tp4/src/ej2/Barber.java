package ej2;

public class Barber extends Thread {
    private final BarberShop barberShop;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        barberShop.attendCustomer();
        run();
    }
}
