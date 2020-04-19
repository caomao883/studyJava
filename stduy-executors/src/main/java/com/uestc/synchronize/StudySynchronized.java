package com.uestc.synchronize;

public class StudySynchronized {
    public static void main(String[] args) {
            test1();
    }

    /**
     * 当对象被线程锁锁住时，其他线程线程不能调用其他有锁的代码
     */
    public static void test1() {
        final StudySynchronized s = new StudySynchronized();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.func1();
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.func2();
            }
        });
        thread2.start();
    }

    private synchronized void func2() {
        System.out.println("func2" + Thread.currentThread().getId());
    }

    public void func1() {
        synchronized(this) {
            System.out.println("func1" + Thread.currentThread().getId());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
