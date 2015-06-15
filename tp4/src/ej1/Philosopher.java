package com.company.ej1;

public class Philosopher extends Thread {
    final String name;
    final Fork left;
    final Fork right;

    public Philosopher(Fork left, Fork right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        eat();
    }

    public void eat() {
        try {
            final int lid = left.getId();
            final int rid = right.getId();

            //            deadlock
            //            left.use();
            //            sleep(50);
            //            right.use();

            //non deadlock
            if (rid > lid) {
                left.use();
                sleep(50); // try force deadlock
                right.use();
            } else {
                right.use();
                sleep(50); // try force deadlock
                left.use();
            }

            System.out.println(name + " is eating");
            sleep(2000);
            left.release();
            right.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
