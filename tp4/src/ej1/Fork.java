package ej1;

import java.util.concurrent.Semaphore;


public class Fork {
    final Semaphore s;
    final int id;

    public Fork(int id) {
        s = new Semaphore(1);
        this.id = id;
    }

    public void use() throws InterruptedException {
        s.acquire();
    }

    public void release() {
        s.release();
    }

    public int getId() {
        return id;
    }
}
