package liou.rayyuan.phenom.model.domain;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import liou.rayyuan.phenom.model.entity._Plurk;

/**
 * Created by louis383 on 16/4/17.
 */
public class Plurk extends _Plurk {

    public Calendar getPostedDateTime() {
        // Mon, 06 Jun 2016 14:07:26 GMT
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.getDefault());
        formatter.setTimeZone(calendar.getTimeZone());

        try {
            calendar.setTime(formatter.parse(getPosted()));
            return calendar;
        } catch (ParseException e) {
            Log.i(this.getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
