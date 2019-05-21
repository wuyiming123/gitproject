package com.iotek.caogao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CaoGao {
    public static void main(String[] args) throws ParseException {
        Date date1 = new Date();
//        Date date2 = new Date();
        DateFormat df2 = DateFormat.getDateTimeInstance();
        System.err.println(df2.format(date1));
        Calendar cal = Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR);//小时
        int minute=cal.get(Calendar.MINUTE);//分
        int second=cal.get(Calendar.SECOND);//秒
        String h = String.valueOf(hour);
        String m = String.valueOf(minute);
        String s = String.valueOf(second);
        String hms = h+":"+m+":"+s;

        String tr_time = "2019-05-30T13:00";
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(tr_time);
        date.getMonth();
        Long ms = (Long) ((date1.getTime()-date.getTime())/1000/24/60);
        System.out.println("ms"+ms);

        /*
        关于上下班打卡设计。首先员工登录进去时判断
        如果时间没到12点 则页面显示上班打卡
        反之就是下班打卡
         */


//        int days = cal(date11,date22);
//        System.out.println(date11+"和"+date22+"之间一共有："+days+"秒");
    }






    public static int cal(String date1,String date2){
        SimpleDateFormat ymd = new SimpleDateFormat("HH:mm:ss");
        try{
            Date d1 = ymd.parse(date1);
            Date d2 = ymd.parse(date2);
            int ms =(int)( ( ( d1.getTime()-d2.getTime() /1000/60)));
            return ms;

        }catch(ParseException e){
            System.out.println();
        }
        return -1;
    }
}
