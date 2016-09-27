package liou.rayyuan.phenom.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

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

        return textSpanned;
    }
}
