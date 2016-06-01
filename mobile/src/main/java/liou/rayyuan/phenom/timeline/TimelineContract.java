package liou.rayyuan.phenom.timeline;

import liou.rayyuan.phenom.BasePresenter;
import liou.rayyuan.phenom.BaseView;
import liou.rayyuan.phenom.model.APIManager;

/**
 * Created by louis383 on 2016/5/29.
 */

public interface TimelineContract {

    interface Presenter extends BasePresenter {
        void fetchTimelime();
        void onActivityResult(int requestCode, int resultCode);
        void setAPIManager(APIManager apiManager);
    }

    interface View extends BaseView<Presenter> {
        void openLoginPage();
        void setupAPIManager();
        void restoreAPIManager(String accessToken, String accessSecret);
    }

}
