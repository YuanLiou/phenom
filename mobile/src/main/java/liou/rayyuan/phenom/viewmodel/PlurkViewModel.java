package liou.rayyuan.phenom.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import java.util.Calendar;
import java.util.Locale;

import liou.rayyuan.phenom.model.domain.Plurk;

/**
 * Created by louis383 on 2016/6/6.
 */

public class PlurkViewModel extends BaseObservable {

    private Plurk plurk;
    private Context context;

    public PlurkViewModel(Plurk plurk) {
        this.plurk = plurk;
    }

    public String getFeel() {
        return plurk.getQualifierTranslated();
    }

    public String getTimeStamps() {
        Calendar calendar = plurk.getPostedDateTime();
        String date = String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE);
        String time = String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.HOUR)) + ":" + String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.MINUTE));
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

    public String getOwnerId() {
        return plurk.getOwnerId();
    }

    public int getReadStatus() {
        return plurk.getIsUnread();
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
