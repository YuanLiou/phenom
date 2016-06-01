package liou.rayyuan.phenom.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import liou.rayyuan.phenom.PhenomApplication;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.PreferenceManager;
import liou.rayyuan.phenom.utils.Router;

/**
 * Created by louis383 on 2016/5/29.
 */

public class LoginActivity extends AppCompatActivity {

    public static final int OAUTH_LOGIN = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Creating View
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.main_content);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

            Router router = new Router(getSupportFragmentManager());
            router.addFragmentToActivity(loginFragment, R.id.main_content, LoginFragment.TAG);
        }

        // Creating Presenter
        PreferenceManager preferenceManager = ((PhenomApplication) getApplication()).getPreferenceManager();
        CurrentUserManager currentUserManager = ((PhenomApplication) getApplication()).getCurrentUserManager(preferenceManager);

        new LoginPresenter(currentUserManager, loginFragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.main_content);
                    if (loginFragment.webViewGoBack()) {
                        return true;
                    }

                    break;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
