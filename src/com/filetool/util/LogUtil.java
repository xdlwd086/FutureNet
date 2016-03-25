package com.filetool.util;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogUtil
{
    static class Time
    {
        private static final long start = System.currentTimeMillis();

        private long current = 0;

        public Time()
        {
        }

        public long getTimeDelay()
        {
            current = System.currentTimeMillis();
            return current - start;
        }

        public long getStart()
        {
            return start;
        }
    }

    /**
     * 函数功能：打印当前时间，并计算显示程序的运行时间
     * @param log 开始或结束的字符串标志
     */
    public static void printLog(final String log)
    {

        String logTemp = "{0} date/time is: {1} \r\nuse time is {2} s {3} ms.";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        Time time = new Time();
        long delay = time.getTimeDelay();//利用静态内部类的函数获取延时
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(delay);

        System.err.println(MessageFormat.format(logTemp, new Object[]
        {log, dateString, calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND)}));
    }
}
