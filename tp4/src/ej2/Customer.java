package ej2;

public class Customer extends Thread {
    private final BarberShop barberShop;

    public Customer(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        barberShop.arriveCustomer(this);
    }
}
