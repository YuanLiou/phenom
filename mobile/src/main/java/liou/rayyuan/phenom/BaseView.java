package liou.rayyuan.phenom;

/**
 * Created by louis383 on 16/4/17.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);
    void makeSnackbar(String message);

}
