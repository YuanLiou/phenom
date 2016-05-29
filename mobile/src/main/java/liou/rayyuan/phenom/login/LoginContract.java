package liou.rayyuan.phenom.login;

import android.webkit.WebView;

import liou.rayyuan.phenom.BasePresenter;
import liou.rayyuan.phenom.BaseView;

/**
 * Created by louis383 on 2016/5/28.
 */

public interface LoginContract {

    interface Presenter extends BasePresenter {
        void setupWebView(WebView webView);
    }

    interface View extends BaseView<Presenter> {
        boolean webViewGoBack();
        void finishLogin(String accessKey, String accessSecret);
    }

}
