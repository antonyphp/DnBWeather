package no.dnb.toolbartest.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by 778363aypp on 9/2/2016.
 */
public class Utils {
    public static int convertKelvinToCelcius(float temperatureInKelvin) {
        return (int)(temperatureInKelvin - 273.15f);
    }

    public static String getTimeFromMilliseconds(long timeInMilliSec) {
        Date date = new Date(timeInMilliSec);
        DateFormat formatter = new SimpleDateFormat("hh:mm a");
        String dateFormatted = formatter.format(date);
        return dateFormatted;
    }

    public static String getDayOfWeekFromTimeStamp(long timestampInMilliSec) {
        String[] dayOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

//        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(timestampInMilliSec);
//
//        int dayNum = c.get(Calendar.DAY_OF_WEEK);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.setTimeInMillis(timestampInMilliSec);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek[day-1];
    }

    public static boolean isTimestapWithinSameDay(long dt, long previousTimestamp) {

        return getDayOfWeekFromTimeStamp(dt * 1000).equals(getDayOfWeekFromTimeStamp(previousTimestamp * 1000));
    }
}
