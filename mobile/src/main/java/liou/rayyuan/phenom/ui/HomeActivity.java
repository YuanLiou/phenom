package liou.rayyuan.phenom.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import liou.rayyuan.phenom.PhenomApplication;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.model.APIManager;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.DependencyCollection;
import liou.rayyuan.phenom.model.PreferenceManager;
import liou.rayyuan.phenom.presenter.HomePresenter;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomePresenter.ViewHandler {
    private static final String TAG = "HomeActivity";
    private Button loginButton;
    private WebView loginWebView;
    private TextView demoText;

    private HomePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loginButton = (Button) findViewById(R.id.login_button);
        loginWebView = (WebView) findViewById(R.id.login_webview);
        demoText = (TextView) findViewById(R.id.text_message);
        loginWebView.getSettings().setJavaScriptEnabled(true);

        loginButton.setOnClickListener(this);

        presenter = new HomePresenter(buildDependencies());
        presenter.attachView(this);
    }

    private DependencyCollection buildDependencies() {
        PreferenceManager preferenceManager = ((PhenomApplication) getApplication()).getPreferenceManager(this);
        CurrentUserManager currentUserManager = ((PhenomApplication) getApplication()).getCurrentUserManager(preferenceManager);

        DependencyCollection dependencyCollection = new DependencyCollection();
        dependencyCollection.setPreferenceManager(preferenceManager);
        dependencyCollection.setCurrentUserManager(currentUserManager);
        return dependencyCollection;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (loginWebView.canGoBack()) {
                        loginWebView.goBack();
                        return true;
                    }
                    break;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                presenter.buttonPressed();
                break;
        }
    }

    @Override
    public void loadUrl(String uri) {
        loginWebView.loadUrl(uri);
    }

    @Override
    public void setWebViewClient() {
        loginWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("oauth")) {
                    Uri uri = Uri.parse(url);
                    presenter.getAccessKey(uri);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void webviewVisibility(boolean isVisible) {
        loginWebView.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void initAPIManager(String accessToken, String accessSecret) {
        APIManager apiManager = ((PhenomApplication) getApplication()).getApiManager(accessToken, accessSecret);
        presenter.setAPIManager(apiManager);
    }

    @Override
    public void initUserLogoutUI() {
        loginButton.setText("Login");
        demoText.setText("");
    }

    @Override
    public void initUserIsLoginUI() {
        loginButton.setText("Logout");
        loginButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void setWebViewVisible() {
        loginButton.setVisibility(View.GONE);
        loginWebView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setTimelineDemo(String text) {
        demoText.setText(text);
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
