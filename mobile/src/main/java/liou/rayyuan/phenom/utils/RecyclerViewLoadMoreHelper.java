package liou.rayyuan.phenom.utils;

/**
 * Created by louis383 on 2016/6/22.
 */

public class RecyclerViewLoadMoreHelper {

    public interface Callback {
        void onLoadMore(int totalItemCount, int itemBeforeMore, int maxVisiblePosition);
    }
}
