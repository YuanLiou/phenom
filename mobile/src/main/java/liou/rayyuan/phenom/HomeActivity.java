package liou.rayyuan.phenom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import liou.rayyuan.phenom.model.OauthManager;
import liou.rayyuan.phenom.model.SharePreferenceManager;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                SharePreferenceManager sharePreferenceManager = new SharePreferenceManager(this);

                OauthManager oauthManager = new OauthManager(getSupportFragmentManager());
                oauthManager.setCredentialStore(sharePreferenceManager);
                String token = oauthManager.authAccount();

                Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
