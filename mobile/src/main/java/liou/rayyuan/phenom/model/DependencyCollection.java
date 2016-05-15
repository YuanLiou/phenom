package liou.rayyuan.phenom.model;

/**
 * Created by louis383 on 16/5/8.
 */
public class DependencyCollection {

    private APIManager apiManager;
    private CurrentUserManager currentUserManager;
    private PreferenceManager preferenceManager;

    public void setApiManager(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public void setCurrentUserManager(CurrentUserManager currentUserManager) {
        this.currentUserManager = currentUserManager;
    }

    public void setPreferenceManager(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public APIManager getApiManager() {
        return apiManager;
    }

    public CurrentUserManager getCurrentUserManager() {
        return currentUserManager;
    }

    public PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }

}
