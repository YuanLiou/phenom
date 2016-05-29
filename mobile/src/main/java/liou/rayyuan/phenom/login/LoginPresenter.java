package liou.rayyuan.phenom.login;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.OAuthManager;
import liou.rayyuan.phenom.model.domain.Token;

/**
 * Created by louis383 on 16/4/17.
 */
public class LoginPresenter implements OAuthManager.oAuthCallback, LoginContract.Presenter {

    private LoginContract.View view;
    private OAuthManager oAuthManager;
    private WebView webView;

    private CurrentUserManager currentUserManager;

    public LoginPresenter(CurrentUserManager currentUserManager, LoginContract.View view) {
        this.currentUserManager = currentUserManager;
        this.view = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setupWebView(WebView webView) {
        this.webView = webView;
        getRequestKey();
    }

    private void getRequestKey() {
        oAuthManager = new OAuthManager(this);
        oAuthManager.initPlurkRequestKey();
    }

    private void getAccessKey(Uri uri) {
        oAuthManager.initPlurkAccessKey(uri);
    }

    //region oAuthCallback
    @Override
    public void onReceivedRequestKey(String url) {
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith(OAuthManager.URL_STARTWITH)) {
                    Uri uri = Uri.parse(url);
                    getAccessKey(uri);

                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void onReceivedAccessKey(String accessKey, String accessSecret, Token userToken) {
        currentUserManager.login(userToken);
        view.finishLogin(accessKey, accessSecret);
    }
    //endregion
}
