package liou.rayyuan.phenom.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import liou.rayyuan.phenom.utils.UrlDrawable;

import static com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager.TAG;

/**
 * Created by louis383 on 2016/6/25.
 */

public class RichTextView extends TextView {

    private Context context;

    public RichTextView(Context context) {
        super(context);
        this.context = context;
    }

    public RichTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public RichTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public RichTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        Spanned spannedText = parseHTMLToRichText(text);
        super.setText(spannedText, type);
    }

    private Spanned parseHTMLToRichText(CharSequence text) {
        Spanned textSpanned = Html.fromHtml(text.toString(), new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                if (TextUtils.isEmpty(source)) {
                    return null;
                }

                UrlDrawable urlDrawable = new UrlDrawable();

                ImageGetterHander imageGetterHander = new ImageGetterHander(urlDrawable);
                imageGetterHander.execute(source);
                return urlDrawable;
            }
        }, null);

        return textSpanned;
    }

    class ImageGetterHander extends AsyncTask<String, Void, Drawable> {

        private UrlDrawable imageDrawable;

        public ImageGetterHander(UrlDrawable imageDrawable) {
            this.imageDrawable = imageDrawable;
        }

        @Override
        protected Drawable doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    Drawable drawable = Drawable.createFromStream(inputStream, "src");
                    drawable.setBounds(0, 0, 100+ drawable.getIntrinsicWidth(), 100 + drawable.getIntrinsicHeight());

                    return drawable;
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "doInBackground Exception" + e.getLocalizedMessage());
            } catch (IOException ioException) {
                Log.e(TAG, "doInBackground: Exception" + ioException.getLocalizedMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            super.onPostExecute(drawable);
            imageDrawable.setBounds(0, 0, 100 + drawable.getIntrinsicWidth(), 100 + drawable.getIntrinsicHeight());
            imageDrawable.setDrawable(drawable);

            RichTextView.this.invalidate();
        }
    }
}
