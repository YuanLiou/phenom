package liou.rayyuan.phenom.presenter;

import android.net.Uri;

import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.DependencyCollection;
import liou.rayyuan.phenom.model.OAuthManager;
import liou.rayyuan.phenom.model.PreferenceManager;
import liou.rayyuan.phenom.model.domain.Page;
import liou.rayyuan.phenom.model.domain.Token;
import liou.rayyuan.phenom.ui.handler.CommomViewHandler;
import retrofit2.Response;
import rx.functions.Action1;

/**
 * Created by louis383 on 16/4/17.
 */
public class HomePresenter implements OAuthManager.oAuthCallback, Presenter<HomePresenter.ViewHandler> {

    private HomePresenter.ViewHandler view;
    private OAuthManager oAuthManager;

    private APIManager apiManager;
    private CurrentUserManager currentUserManager;
    private PreferenceManager preferenceManager;

    public HomePresenter(DependencyCollection dependencies) {
        currentUserManager = dependencies.getCurrentUserManager();
        preferenceManager = dependencies.getPreferenceManager();
    }

    @Override
    public void attachView(ViewHandler view) {
        this.view = view;
        if (currentUserManager.isLogin()) {
            view.initUserIsLoginUI();
            currentUserManager.restoreLoginState();

            view.initAPIManager(currentUserManager.getAccessKey(), currentUserManager.getAccessSecret());

            fetchTimeline();
        } else {
            view.initUserLogoutUI();
        }
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public void buttonPressed() {
        if (currentUserManager.isLogin()) {
            currentUserManager.logout();
            view.initUserLogoutUI();
        } else {
            getRequestKey();
            view.setWebViewVisible();
        }
    }

    private void getRequestKey() {
        oAuthManager = new OAuthManager(this);
        view.webviewVisibility(true);
        oAuthManager.initPlurkRequestKey();
    }

    public void getAccessKey(Uri uri) {
        oAuthManager.initPlurkAccessKey(uri);
    }

    public void setAPIManager(APIManager apiManager) {
        this.apiManager = apiManager;
        currentUserManager.setApiManager(apiManager);
        fetchTimeline();
    }

    public void fetchTimeline() {
        apiManager.getTimelimePlurks(0).subscribe(new Action1<Response<Page>>() {
            @Override
            public void call(Response<Page> pageResponse) {
                view.setTimelineDemo(pageResponse.body().getPlurks().get(0).getContent());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                view.makeToast(throwable.getMessage());
            }
        });
    }

    //region oAuthCallback
    @Override
    public void onReceivedRequestKey(String url) {
        view.loadUrl(url);
        view.setWebViewClient();
    }

    @Override
    public void onReceivedAccessKey(String accessKey, String accessSecret, Token userToken) {
        view.webviewVisibility(false);
        view.initAPIManager(accessKey, accessSecret);

        currentUserManager.login(userToken);
        view.initUserIsLoginUI();
    }
    //endregion

    public interface ViewHandler extends CommomViewHandler {
        void loadUrl(String uri);
        void setWebViewClient();
        void webviewVisibility(boolean isVisible);
        void initAPIManager(String accessToken, String accessSecret);
        void initUserLogoutUI();
        void initUserIsLoginUI();
        void setWebViewVisible();
        void setTimelineDemo(String text);
    }
}
