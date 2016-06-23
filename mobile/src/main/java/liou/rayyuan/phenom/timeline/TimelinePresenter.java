package liou.rayyuan.phenom.timeline;

import android.app.Activity;

import com.orhanobut.logger.Logger;

import liou.rayyuan.phenom.login.LoginActivity;
import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.Paginator;
import liou.rayyuan.phenom.model.domain.Page;
import liou.rayyuan.phenom.model.repository.PlurkDataProvider;
import liou.rayyuan.phenom.model.repository.UserDataProvider;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by louis383 on 2016/6/1.
 */

public class TimelinePresenter implements TimelineContract.Presenter, Paginator.Callback {

    private TimelineContract.View view;
    private CurrentUserManager currentUserManager;
    private APIManager apiManager;

    private Paginator paginator;
    private PlurkDataProvider plurkDataProvider;
    private UserDataProvider userDataProvider;

    public TimelinePresenter(CurrentUserManager userManager, TimelineContract.View view) {
        this.currentUserManager = userManager;
        this.view = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {
        if (currentUserManager.isLogin()) {
            currentUserManager.restoreLoginState();
            view.restoreAPIManager(currentUserManager.getAccessKey(), currentUserManager.getAccessSecret());
            fetchTimelime();
        } else {
            view.openLoginPage();
        }
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setAPIManager(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == LoginActivity.OAUTH_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                view.setupAPIManager();
                fetchTimelime();
            }
        }
    }

    @Override
    public void fetchTimelime() {
        plurkDataProvider = new PlurkDataProvider();
        userDataProvider = new UserDataProvider();

        paginator = new Paginator(this);
        paginator.load();
    }

    @Override
    public void loadMore(int currentItemCount) {
        if (currentItemCount > 0) {
            paginator.load();
        }
    }

    @Override
    public PlurkDataProvider getPlurkDataProvider() {
        return plurkDataProvider;
    }

    @Override
    public UserDataProvider getUserDataProvider() {
        return userDataProvider;
    }

    //region Paginator
    @Override
    public void paginatorEnd() {
        //TODO:: There have nothing to show
    }

    @Override
    public Observable<Response<Page>> paginatorNextCall(int offset) {
        return apiManager.getTimelimePlurks(offset);
    }

    @Override
    public void paginatorOnLoaded(Page page) {
        plurkDataProvider.addItems(page.getPlurks());
        userDataProvider.addUsers(page.getPlurkUsers().getResultMap());

        view.notifyDataSetChanged();
    }

    @Override
    public void paginatorOnError(Throwable throwable) {
        Logger.e(throwable.getLocalizedMessage());
    }
    //endregion
}
