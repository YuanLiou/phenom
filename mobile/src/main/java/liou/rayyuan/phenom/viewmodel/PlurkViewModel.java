package liou.rayyuan.phenom.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

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

    public Spanned getMessage() {
        if (context == null) {
            return null;
        }

        Spanned textSpanned = Html.fromHtml(plurk.getContent(), new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                if (TextUtils.isEmpty(source)) {
                   return null;
                }

                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                ImageRequestBuilder requestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(source));
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(requestBuilder.build())
                        .setOldController(simpleDraweeView.getController())
                        .setAutoPlayAnimations(true)
                        .build();

                simpleDraweeView.setController(controller);

                Drawable drawable = simpleDraweeView.getTopLevelDrawable();
                drawable.setBounds(0, 0, 100, 100);

                return drawable;
            }
        }, null);

        ObservableField<Spanned> observableSpanned = new ObservableField<>(textSpanned);
        observableSpanned.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                notifyPropertyChanged(liou.rayyuan.phenom.BR.plurk);
            }
        });

        return observableSpanned.get();
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
