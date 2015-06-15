package com.company.ej2;

public class BarberShop {
    private final Customer[] waiting;
    private Customer cutting;

    public BarberShop(int maxWaiting) {
        waiting = new Customer[maxWaiting];
    }

    public void enter(Customer customer) {
        if (!fullCapacity()) {
            int i = 0;

            while (waiting[i] != null)
                i++;

            waiting[i] = customer;
        }
    }

    public void cut() {
        int i = 0;

        while (waiting[i] == null)
            i++;

        final Customer customer = waiting[i];
        waiting[i] = null;
    }

    private boolean fullCapacity() {
        for (Customer customer : waiting) {
            if (customer == null) {
                return false;
            }
        }

        return true;
    }
}
