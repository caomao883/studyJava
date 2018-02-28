package com.uestc.string;

public class Main {
    public static void main(String[] args){

        //study_format();
        studysplit();
    }

    private static void study_format() {
        String ss = String.format("%d   %d\n",3,4);
        System.out.print(ss);
    }


    private static void studysplit() {

        //split(),split(,-1) 区别
        System.out.println("split()");
        String a = "123:124354:455";
        //第二个是表示只分为多少部分，后面的不管
        String[] arrs = a.split(":");
        int i=0;
        for (String arr:arrs){
            i++;
            System.out.println(i + " String = " +arr);
        }

        System.out.println("\nsplit(,-1)");
        a = "123:124354::455";
        //第二个是表示只分为多少部分，后面的不管
        arrs = a.split(":",-1);
        i=0;
        for (String arr:arrs){
            i++;
            System.out.println(i + " String = " +arr);
        }

    }
}
