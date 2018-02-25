package com.uestc.studysubmit;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class StudySubmit {
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
        List<StudySubmit.MyTask> tasks = new ArrayList<StudySubmit.MyTask>();
        List<java.util.concurrent.Future<Integer>> futures= new ArrayList<java.util.concurrent.Future<Integer>>();
        ExecutorService executors =  Executors.newFixedThreadPool(3);
        for(int i = 0;i<n;++i){
            tasks.add(new StudySubmit.MyTask(2.f,i));
        }
        for(StudySubmit.MyTask myTask:tasks){
            futures.add(executors.submit(myTask));
        }
        System.out.println("dfasfdsaf");

        List<Integer> mylist = new ArrayList<Integer>();
        int i = 0;
        for(java.util.concurrent.Future<Integer> future:futures){
            System.out.println("......");
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

        StudySubmit myInvokeAll = new StudySubmit();
        myInvokeAll.deel();
    }

}
