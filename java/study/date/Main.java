package study.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args){
            getTimeStamp();
    }
    /**
     * 获取当前时间指定时间格式
     * Gets the current time specified format
     * @return
     * 2018-02-06 23:32;17.017
     */
    public static String getDate01() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss.sss"); // 得到一个"yyyy-MM-dd
        // HH:mm;ss.sss"格式日期
        return sd.format(new Date());
    }

    /**
     * Date使用
     */
    public static void getTimeStamp(){
        //getTime():返回的时间是距离1970年的毫秒数
        //date值受setTime()的影响
        Date date=new Date();
        long current=date.getTime();
        System.out.println(current);//1472002479966
        System.out.println(date);//Wed Aug 24 09:34:39 CST 2016
        long time=current+1000*60*60*24;//时间设置为明日此时
        date.setTime(time);
        System.out.println(date.getTime());//1472002479966
        System.out.println(current);//1472002479966
        System.out.println(date);// Thu Aug 25 09:34:39 CST 2016

    }
}
