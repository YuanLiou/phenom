package liou.rayyuan.phenom.presenter;

import android.net.Uri;

import liou.rayyuan.phenom.model.OAuthManager;
import liou.rayyuan.phenom.ui.handler.CommomViewHandler;

/**
 * Created by louis383 on 16/4/17.
 */
public class HomePresenter implements OAuthManager.oAuthCallback, Presenter<HomePresenter.ViewHandler> {

    private HomePresenter.ViewHandler view;
    private CommomViewHandler commomViewHandler;
    private OAuthManager oAuthManager;

    public HomePresenter(HomePresenter.ViewHandler view) {
        attachView(view);
        oAuthManager = new OAuthManager(this);
    }

    @Override
    public void attachView(ViewHandler view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        this.commomViewHandler = null;
    }

    public void setCommomViewHandler(CommomViewHandler commomViewHandler) {
        this.commomViewHandler = commomViewHandler;
    }

    public void getRequestKey() {
        view.webviewVisibility(true);
        oAuthManager.initPlurkRequestKey();
    }

    public void getAccessKey(Uri uri) {
        oAuthManager.initPlurkAccessKey(uri);
    }

    //region oAuthCallback
    @Override
    public void onReceivedRequestKey(String url) {
        view.loadUrl(url);
        view.setWebViewClient();
    }

    @Override
    public void onReceivedAccessKey(String accessKey, String accessSecret) {
        view.webviewVisibility(false);
        commomViewHandler.makeToast("Token -> " + accessKey);
        commomViewHandler.makeToast("Secret -> " + accessSecret);
    }
    //endregion

    public interface ViewHandler {
        void loadUrl(String uri);
        void setWebViewClient();
        void webviewVisibility(boolean isVisible);
    }

}
