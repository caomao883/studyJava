package study.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Long getTimestampByString(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0l;
        }
    }

    /**
     * 获取num天前的时间
     * Time for n days before to the specified format
     *
     * @param specifiedDay
     * @param num
     * @return
     */
    public static String getSpecifiedDayBefore(String specifiedDay, int num) {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            date = sdf.parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - num);

        String dayBefore = sdf.format(c.getTime());
        return dayBefore;
    }



    public static void main(String[] args) {
        String str = getSpecifiedDayBefore("20161215", 15);
        System.out.println(str);
    }
}