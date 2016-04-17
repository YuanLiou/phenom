package liou.rayyuan.phenom.presenter;

/**
 * Created by louis383 on 16/4/17.
 */
public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
