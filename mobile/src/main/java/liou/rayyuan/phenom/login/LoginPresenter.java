package liou.rayyuan.phenom.login;

import android.net.Uri;

import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.OAuthManager;
import liou.rayyuan.phenom.model.domain.Token;

/**
 * Created by louis383 on 16/4/17.
 */
public class LoginPresenter implements OAuthManager.oAuthCallback, LoginContract.Presenter {

    private LoginContract.View view;
    private OAuthManager oAuthManager;

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
    public void initLogin() {
        getRequestKey();
    }

    @Override
    public void continueToLogin(Uri uri) {
        getAccessKey(uri);
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
        view.setWebViewClient(url);
    }

    @Override
    public void onReceivedAccessKey(String accessKey, String accessSecret, Token userToken) {
        currentUserManager.login(userToken);
        view.finishLogin(accessKey, accessSecret);
    }

    @Override
    public void onOAuthLoginError(String errorMessage) {
        view.makeSnackbar(errorMessage);
    }

    //endregion
}
