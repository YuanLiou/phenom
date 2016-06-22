package liou.rayyuan.phenom.timeline;

import liou.rayyuan.phenom.BasePresenter;
import liou.rayyuan.phenom.BaseView;
import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.repository.PlurkDataProvider;
import liou.rayyuan.phenom.model.repository.UserDataProvider;

/**
 * Created by louis383 on 2016/5/29.
 */

public interface TimelineContract {

    interface Presenter extends BasePresenter {
        void fetchTimelime();
        void onActivityResult(int requestCode, int resultCode);
        void setAPIManager(APIManager apiManager);
        PlurkDataProvider getPlurkDataProvider();
        UserDataProvider getUserDataProvider();
    }

    interface View extends BaseView<Presenter> {
        void openLoginPage();
        void setupAPIManager();
        void restoreAPIManager(String accessToken, String accessSecret);
        void notifyDataSetChanged();
    }

}
