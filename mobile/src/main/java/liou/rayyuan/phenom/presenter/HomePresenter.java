package liou.rayyuan.phenom.presenter;

import android.net.Uri;

import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.OAuthManager;
import liou.rayyuan.phenom.model.domain.Page;
import liou.rayyuan.phenom.ui.handler.CommomViewHandler;
import retrofit2.Response;
import rx.functions.Action1;

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

    public void initAPIManager(String accessToken, String accessSecret) {
        APIManager apiManager = new APIManager(accessToken, accessSecret);
        apiManager.getTimelimePlurks("").subscribe(new Action1<Response<Page>>() {
            @Override
            public void call(Response<Page> pageResponse) {
//                Sample ->                 
//                Map<String, PlurkUsersDetail> maps = pageResponse.body().getPlurkUsers().getResultMap();
//                Log.i("PlurkUsersDetail -> ", maps.get("3807744").getFullName());
//                Log.i("PlurkTimeline -> ", pageResponse.body().getPlurks().get(0).getContent());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
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
    public void onReceivedAccessKey(String accessKey, String accessSecret) {
        view.webviewVisibility(false);
        initAPIManager(accessKey, accessSecret);
    }
    //endregion

    public interface ViewHandler {
        void loadUrl(String uri);
        void setWebViewClient();
        void webviewVisibility(boolean isVisible);
    }

}
