package io.renren.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期 deal with
 * 
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/**  time 格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/**  time 格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
