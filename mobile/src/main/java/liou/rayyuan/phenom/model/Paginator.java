package liou.rayyuan.phenom.model;


import liou.rayyuan.phenom.model.domain.Page;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by louis383 on 2016/6/22.
 */

public class Paginator {
    public static final int LIMIT = 30;

    private Observable<Response<Page>> nextCall;
    private Subscription nextSubscription;

    private Callback callback;
    private int offset;
    private boolean readEnd;

    public Paginator(Callback callback) {
        this.callback = callback;
        this.offset = 0;

        nextCall = prepareNextCall();
    }

    public void load() {
        if (readEnd) {
            return;
        }

        nextSubscription = nextCall.subscribe(new Action1<Response<Page>>() {
            @Override
            public void call(Response<Page> pageResponse) {
                if (pageResponse.isSuccessful()) {
                    Page page = pageResponse.body();

                    readEnd = page.getPlurks().isEmpty();
                    if (readEnd) {
                        callback.paginatorEnd();
                    }

                    offset += LIMIT;
                    nextCall = prepareNextCall();

                    callback.paginatorOnLoaded(page);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                callback.paginatorOnError(throwable);
                throwable.printStackTrace();
            }
        });
    }

    public void reset() {
        offset = 0;
        readEnd = false;
        nextSubscription.unsubscribe();
        nextCall = prepareNextCall();
    }

    public void cancel() {
        nextSubscription.unsubscribe();
    }

    private Observable<Response<Page>> prepareNextCall() {
        return callback.paginatorNextCall(offset);
    }

    public interface Callback {
        Observable<Response<Page>> paginatorNextCall(int offset);
        void paginatorOnLoaded(Page page);
        void paginatorOnError(Throwable throwable);
        void paginatorEnd();
    }
}
