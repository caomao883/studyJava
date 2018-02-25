package com.uestc.executors;

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
            futures = executors.invokeAll(tasks,5L,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dfasfdsaf");
        List<Integer> mylist = new ArrayList<Integer>();
        int i = 0;
        for(Future<Integer> future:futures){

            try {
                mylist.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e){
                System.out.println(tasks.get(i).id + " is cancel");
            }
            i++;
        }
        for (Integer integer:mylist){
            System.out.println(integer);
        }
        executors.shutdown();
    }
    public static void main(String[] args){

        MyInvokeAll myInvokeAll = new MyInvokeAll();
        myInvokeAll.deel();
    }

}
