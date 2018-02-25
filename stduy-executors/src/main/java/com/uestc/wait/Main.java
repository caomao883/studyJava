package com.uestc.wait;

public class Main {
    public static void main(String[] args) {
        final MyObject object = new MyObject();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object) {
                        object.produce();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object) {
                        object.consume();
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
