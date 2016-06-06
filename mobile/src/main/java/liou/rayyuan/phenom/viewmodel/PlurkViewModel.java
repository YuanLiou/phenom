package liou.rayyuan.phenom.viewmodel;

import java.util.Calendar;
import java.util.Locale;

import liou.rayyuan.phenom.model.domain.Plurk;

/**
 * Created by louis383 on 2016/6/6.
 */

public class PlurkViewModel {

    private Plurk plurk;

    public PlurkViewModel(Plurk plurk) {
        this.plurk = plurk;
    }

    public String getFeel() {
        return plurk.getQualifierTranslated();
    }

    public String getTimeStamps() {
        Calendar calendar = plurk.getPostedDateTime();
        String date = String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.MONTH)) + "/" + calendar.get(Calendar.DATE);
        String time = String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.HOUR)) + ":" + calendar.get(Calendar.MINUTE);
        return date + " " + time;
    }

    public String getMessageCount() {
        return String.valueOf(plurk.getResponseCount());
    }

    public String getMessage() {
        return plurk.getContent();
    }

    public String getPlurkId() {
        return plurk.getPlurkId();
    }
}
