package liou.rayyuan.phenom.login;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import liou.rayyuan.phenom.PhenomApplication;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.model.OAuthManager;

public class LoginFragment extends Fragment implements LoginContract.View {
    public static final String TAG = "LoginFragment";
    private WebView loginWebView;
    private View layout;

    private LoginContract.Presenter presenter;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.layout = view;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginWebView = (WebView) view.findViewById(R.id.login_webview);
        loginWebView.getSettings().setJavaScriptEnabled(true);

        presenter.initLogin();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean webViewGoBack() {
        if (loginWebView.canGoBack()) {
            loginWebView.goBack();

            return true;
        }
        return false;
    }

    @Override
    public void setWebViewClient(String url) {
        loginWebView.loadUrl(url);
        loginWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith(OAuthManager.URL_STARTWITH)) {
                    Uri uri = Uri.parse(url);
                    presenter.continueToLogin(uri);

                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void finishLogin(String accessKey, String accessSecret) {
        ((PhenomApplication) getActivity().getApplication()).setApiManager(accessKey, accessSecret);
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void makeSnackbar(String message) {
        Snackbar.make(layout, message, Snackbar.LENGTH_SHORT).show();
    }
}