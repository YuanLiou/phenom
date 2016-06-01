package liou.rayyuan.phenom.timeline;

import android.app.Activity;

import liou.rayyuan.phenom.login.LoginActivity;
import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.CurrentUserManager;

/**
 * Created by louis383 on 2016/6/1.
 */

public class TimelinePresenter implements TimelineContract.Presenter {

    private TimelineContract.View view;
    private CurrentUserManager currentUserManager;
    private APIManager apiManager;

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
        view.makeSnackbar(currentUserManager.getAccessSecret());
    }

}
