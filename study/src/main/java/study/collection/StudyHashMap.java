package study.collection;


import java.util.*;

public class StudyHashMap {
    public static  void main(String[] args){

        //study1();
        //sortMapByKey();
        sortMapByValue();
    }

    /**
     * 按value排序
     */
    private static void sortMapByValue() {
        Map<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("c",1);
        hashMap.put("b",2);
        hashMap.put("a",-1);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            };
        });
        Map<String,Integer> sortedMap = new LinkedHashMap<String,Integer>();
        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        Set<Map.Entry<String,Integer>> entrySet = sortedMap.entrySet();
        for (Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    /**
     * 按key值从大到小排列
     */
    private static void sortMapByKey() {
        Map<String,Integer> hashMap = new TreeMap<String,Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("c",-1);
        hashMap.put("d",5);
        Set<Map.Entry<String,Integer>> entrySet = hashMap.entrySet();
        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey()+"," + entry.getValue());
        }
    }

    /**
     * 遍历HashMap
     */
    private static void study1() {
        Map<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("c",-1);
        Set<Map.Entry<String,Integer>> entrySet = hashMap.entrySet();
        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey()+"," + entry.getValue());
        }
        if (hashMap.containsKey("a")){
            System.out.println("hashMap contain Key: a");
        }
        if (hashMap.containsValue(1)){
            System.out.println("hashMap contain Key: 1");
        }
    }

}
