package liou.rayyuan.phenom.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

/**
 * Created by louis383 on 2016/6/22.
 */

public class RecyclerViewLoadMoreHelper {

    private RecyclerView recyclerView;
    private Callback callback;

    private int maxCountToLoadMore;
    private boolean isLoadingMore;

    public RecyclerViewLoadMoreHelper(RecyclerView recyclerView, Callback callback) {
        this(recyclerView, callback, 10);
    }

    public RecyclerViewLoadMoreHelper(RecyclerView recyclerView, Callback callback, int maxCountToLoadMore) {
        this.recyclerView = recyclerView;
        this.callback = callback;
        this.maxCountToLoadMore = maxCountToLoadMore;

        initLoadMore();
    }

    private void initLoadMore() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                processLoadMore();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    private void processLoadMore() {
        if (callback == null) {
            return;
        }

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            Logger.e("only accept LinearLayoutManager in current version of LoadMoreHelper");
            return;
        }

        int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int offscreenNextItemPosition = totalItemCount - lastVisibleItemPosition;

        if ((offscreenNextItemPosition <= maxCountToLoadMore && totalItemCount > visibleItemCount) && !isLoadingMore) {
            enableLoadMore(false);

            callback.onLoadMore(recyclerView.getAdapter().getItemCount(), maxCountToLoadMore, lastVisibleItemPosition);
        }
    }

    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public void enableLoadMore(boolean loadingMore) {
        isLoadingMore = !loadingMore;
    }

    public void setMaxCountToLoadMore(int maxCountToLoadMore) {
        this.maxCountToLoadMore = maxCountToLoadMore;
    }

    public void removeLoadMoreCallBack() {
        this.callback = null;
    }

    public interface Callback {
        void onLoadMore(int totalItemCount, int itemBeforeMore, int maxVisiblePosition);
    }
}
