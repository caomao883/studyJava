package study.collection;

import java.util.*;

public class Main {
    public static void main(String[] args){

        studylist();
        studymap();
    }

    private static void studymap() {
        Map<String,Integer> map1 = new TreeMap<String,Integer>();
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",-1);
        Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) map1.entrySet();

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

