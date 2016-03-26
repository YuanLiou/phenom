package liou.rayyuan.phenom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import liou.rayyuan.phenom.model.OauthManager;
import liou.rayyuan.phenom.model.SharePreferenceManager;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, OauthManager.oauthManagerHandler {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    //region View.OnClickListenr
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                SharePreferenceManager sharePreferenceManager = new SharePreferenceManager(this);

                OauthManager oauthManager = new OauthManager(getSupportFragmentManager());
                oauthManager.setCredentialStore(sharePreferenceManager);
                oauthManager.setCallbackHandler(this);
                oauthManager.authAccountDirtyWay();
                break;
        }
    }
    //endregion

    //region OauthManagerHandler
    @Override
    public void onAuthCallBack(String token) {
        Toast.makeText(this, "Access Token is => " + token, Toast.LENGTH_SHORT).show();
    }
    //endregion
}
