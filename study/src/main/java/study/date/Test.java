package study.date;

import java.util.Calendar;

public class Test {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        System.out.print(c.get(Calendar.YEAR));
        System.out.print("  ");
        System.out.print(c.get(Calendar.MONDAY)+1);
        System.out.print("  ");
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
