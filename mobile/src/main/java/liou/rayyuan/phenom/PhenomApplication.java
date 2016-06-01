package liou.rayyuan.phenom;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

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

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }

    public APIManager setApiManager(String accessToken, String accessSecret) {
        if (apiManager == null) {
            apiManager = new APIManager();
        }

        apiManager.setupAPIManager(accessToken, accessSecret);
        return apiManager;
    }

    public APIManager getApiManager() {
        return apiManager;
    }

    public PreferenceManager getPreferenceManager() {
        if (preferenceManager == null) {
            preferenceManager = new PreferenceManager(getApplicationContext());
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