package com.brandis.brandisweb.util;

import javax.sql.rowset.CachedRowSet;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date addDate(Date date, int dates){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dates);
        return calendar.getTime();
    }


}
