package liou.rayyuan.phenom.utils;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by louis383 on 2016/9/27.
 */

public class UrlDrawable extends BitmapDrawable {

    private Drawable drawable;

    @Override
    public void draw(Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
