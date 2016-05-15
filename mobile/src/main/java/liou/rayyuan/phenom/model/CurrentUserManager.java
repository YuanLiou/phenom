package liou.rayyuan.phenom.model;

import android.text.TextUtils;

import liou.rayyuan.phenom.model.domain.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by louis383 on 16/5/8.
 */
public class CurrentUserManager {

    private APIManager apiManager;
    private PreferenceManager preferenceManager;
    private Token userToken;

    public CurrentUserManager(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public CurrentUserManager(APIManager apiManager, PreferenceManager preferenceManager) {
        this.apiManager = apiManager;
        this.preferenceManager = preferenceManager;
    }

    public void setApiManager(APIManager apiManager) {
        this.apiManager = apiManager;
    }

    public void login(Token userToken) {
        this.userToken = userToken;
        String tokenString = Token.JSONSerialization(userToken);
        preferenceManager.setCurrentUser(tokenString);
    }

    public void logout() {
        this.userToken = new Token();
        preferenceManager.removeCurrentUser();
        apiManager.expireToken().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }

    public void restoreLoginState() {
        if (isLogin()) {
            String userTokenString = preferenceManager.getUserTokenString();
            Token token = Token.JSONDeserialization(userTokenString);
            this.userToken = token;
        }
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(preferenceManager.getUserTokenString());
    }

    public String getAccessKey() {
        if (userToken == null) {
            return "";
        }

        return userToken.getOauthToken();
    }

    public String getAccessSecret() {
        if (userToken == null) {
            return "";
        }

        return userToken.getOauthTokenSecret();
    }

}
