package com.uestc.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试主线程卡顿问题
 */
public class Test {

    /**
     * 测试submit是否会卡主线程
     */
    public void func_submit(){
        ExecutorService executor = Executors.newFixedThreadPool(1);
        System.out.println(".....Thread...main...." + Thread.currentThread().getId());
        executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(".....Thread...start...." + Thread.currentThread().getId());
                Thread.sleep(3000);
                System.out.println(".....Thread...end...." + Thread.currentThread().getId());
                return 1;
            }
        });
        System.out.println("....Thread....main..end.."+Thread.currentThread().getId());
    }

    /**
     * 测试invokeAll是否会卡主线程
     */
    public class MyTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println(".....Thread...start...." + Thread.currentThread().getId());
            Thread.sleep(3000);
            System.out.println(".....Thread...end...." + Thread.currentThread().getId());
            return 1;
        }
    }

    /**
     * 会卡主线程
     */
    public void func_invokeAll(){
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<MyTask> tasks = new ArrayList<MyTask>();
        for (int i = 0;i < 10;i++){
            tasks.add(new MyTask());
        }
        System.out.println(".....Thread...main...." + Thread.currentThread().getId());

        try {
            executor.invokeAll(tasks,10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("....Thread....main..end.."+Thread.currentThread().getId());
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        Test test = new Test();
        //test.func_submit();
        test.func_invokeAll();
    }
}
