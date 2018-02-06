import java.util.HashMap;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        HashMap<String,Integer> myHashMap = new HashMap<String, Integer>();
        myHashMap.put("11",1);
        myHashMap.put("22",2);
        myHashMap.put("33",3);
        myHashMap.put("44",3);
        myHashMap.put("55",3);
        myHashMap.put("66",3);
        myHashMap.put("77",3);
        myHashMap.put("88",3);
        Iterator it = myHashMap.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            System.out.println(key);
        }

    }


}
