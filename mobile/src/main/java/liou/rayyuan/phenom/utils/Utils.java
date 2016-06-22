package liou.rayyuan.phenom.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by louis383 on 2016/6/22.
 */

public class Utils {

    public static LinearLayoutManager getLinearLayoutManager(Context context, int orientation) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(orientation);
        return linearLayoutManager;
    }

}
