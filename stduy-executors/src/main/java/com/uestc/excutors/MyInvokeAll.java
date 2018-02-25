package com.uestc.excutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyInvokeAll {
    public class MyTask implements Callable<Integer>{
        float price;
        int id;
        public MyTask(float price,int id){
            this.price = price;
            this.id = id;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println(String.valueOf(price) + " " + String.valueOf(id) + " is invoke");
            Thread.sleep(2000);
            return Math.round(price*id);
        }
    }
    public void deel(){
        int n = 10;
        List<MyTask> tasks = new ArrayList<MyTask>();
        List<Future<Integer>> futures= new ArrayList<Future<Integer>>();
        ExecutorService executors =  Executors.newFixedThreadPool(3);
        for(int i = 0;i<n;++i){
            tasks.add(new MyTask(2.f,i));
        }
        try {
            futures = executors.invokeAll(tasks,10L,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> mylist = new ArrayList<Integer>();
        for(Future<Integer> future:futures){
            try {
                mylist.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (Integer integer:mylist){
            System.out.println(integer);
        }
    }
    public static void main(String[] args){

        MyInvokeAll myInvokeAll = new MyInvokeAll();
        myInvokeAll.deel();
    }

}
