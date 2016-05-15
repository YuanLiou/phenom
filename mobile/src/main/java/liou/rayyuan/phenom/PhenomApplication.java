package liou.rayyuan.phenom;

import android.app.Application;
import android.content.Context;

import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.PreferenceManager;

/**
 * Created by louis383 on 16/5/8.
 */
public class PhenomApplication extends Application {

    private APIManager apiManager;
    private PreferenceManager preferenceManager;
    private CurrentUserManager currentUserManager;

    public APIManager getApiManager(String accessToken, String accessSecret) {
        if (apiManager == null) {
            apiManager = new APIManager(accessToken, accessSecret);
        }
        return apiManager;
    }

    public PreferenceManager getPreferenceManager(Context context) {
        if (preferenceManager == null) {
            preferenceManager = new PreferenceManager(context);
        }
        return preferenceManager;
    }

    public CurrentUserManager getCurrentUserManager(PreferenceManager preferenceManager) {
        if (currentUserManager == null) {
            currentUserManager = new CurrentUserManager(preferenceManager);
        }
        return currentUserManager;
    }
}