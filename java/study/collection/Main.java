package study.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        studylist();
    }
    public static void studylist(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Integer t = (Integer) iterator.next();
            System.out.println(t);
        }

        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(3);
        list1.add(7);
        Iterator iterator1 = list1.iterator();
        System.out.println("................................");
        while (iterator1.hasNext()){
            Integer e = (Integer) iterator1.next();
            System.out.println(e);

        }
    }
}

