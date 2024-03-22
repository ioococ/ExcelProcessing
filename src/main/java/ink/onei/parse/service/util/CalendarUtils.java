package ink.onei.parse.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/03/2024 20:36 Wednesday
 */

public class CalendarUtils {
    public static Calendar toCalendar(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = formatter.parse(dateString);
            calendar.setTime(date);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        return calendar;
    }
}
