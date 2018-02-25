package com.uestc.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar提供了获取各个时间分量的值的方法
 * @author zc
 */
public class T05Calendar2 {
    public static void main(String[] args) {
        //studybase();
        study1();
    }
    public static void studybase(){
        Calendar c=Calendar.getInstance();
        //获取年
        int year=c.get(Calendar.YEAR);
        System.out.println("year:"+year);//2016
        //获取月:月从0开始!!!,0表示一月
        int month=c.get(Calendar.MONTH);
        System.out.println("month:"+month);//7
		/*
		 * 和天相关的时间分量
		 * DATE,DAY_OF_MONTH:是一致的,表示月中的第几天
		 * DAY_OF_YEAR:表示年中的天
		 * DAY_OF_WEEK:表示周中的天
		 *
		 * */
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));

        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));

        int dow=c.get(Calendar.DAY_OF_WEEK)-1;

        String[] data={"日","一","二","三","四","五","六"};
        System.out.println("周"+data[dow]);

        //获取小时,分钟,秒 	HOUR_OF_DAY:24小时	HOUR:12小时
        System.out.println(c.get(Calendar.HOUR_OF_DAY));//14
        System.out.println(c.get(Calendar.HOUR));//2
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));
    }

    /**
     * 设置时间
     */
    public static void study1(){
        //默认创建出来的Calendar的实现类表示当前系统时间
        Calendar c=Calendar.getInstance();
        //将Calendar转换为Date
        Date date=c.getTime();

        //Date->Calendar
		/*
		 * void setTime(Date date)
		 * 该方法可以使当前Calendar表示给定的
		 * Date所表示的时间
		 * */
        c.setTime(date);
        System.out.println(c.getTime());
    }
}
