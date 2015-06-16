package ej2;


import java.util.Random;

public class BarberShop {
    final int MAX_CAPACITY;
    int waitingQty;
    Customer readyToBeAttended;

    public BarberShop(int max_capacity) {
        MAX_CAPACITY = max_capacity;
        waitingQty = 0;
        readyToBeAttended = null;
    }

    public boolean isFull() {
        return waitingQty >= MAX_CAPACITY;
    }

    public synchronized void arriveCustomer(Customer customer) {
        if (!isFull()){
            waitingQty++;
            if (readyToBeAttended == null){
                readyToBeAttended = customer;
                notifyAll();
            } else {
                try {
                    wait();
                    System.out.println(customer + " is waiting for the barber.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(customer + " left without an awesome haircut.");
        }
    }

    public synchronized void attendCustomer(){
        if(readyToBeAttended == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(readyToBeAttended + "got an awesome haircut. Now he's handsome as me.");
            readyToBeAttended = null;
            final Random random = new Random(System.currentTimeMillis());
            try {
                Thread.sleep(random.nextInt(1300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitingQty--;
            notifyAll();
        }
    }


}
