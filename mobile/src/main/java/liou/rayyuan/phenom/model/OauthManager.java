package liou.rayyuan.phenom.model;

import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.jackson.JacksonFactory;
import com.wuman.android.auth.AuthorizationDialogController;
import com.wuman.android.auth.AuthorizationFlow;
import com.wuman.android.auth.DialogFragmentController;
import com.wuman.android.auth.OAuthManager;
import com.wuman.android.auth.oauth2.store.SharedPreferencesCredentialStore;

import java.io.IOException;

import liou.rayyuan.phenom.BuildConfig;

/**
 * Created by louis383 on 16/3/26.
 */
public class OauthManager {

    private SharedPreferencesCredentialStore credentialStore;
    private FragmentManager fragmentManager;
    private String token;

    public OauthManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public String authAccount() {
        ClientParametersAuthentication client = new ClientParametersAuthentication(BuildConfig.PLURK_APPKEY, BuildConfig.PLURK_APPSECRET);
        AuthorizationFlow flow = setupAuthorizationFlow(client);
        AuthorizationDialogController dialogController = setupAuthDialog(fragmentManager);

        final OAuthManager oAuthManager = new OAuthManager(flow, dialogController);

        token = "";

        // FIXME:: Dirty code. fix it as soon as possable!
        new AsyncTask<String, String, Boolean>() {
            Credential credential;
            @Override
            protected Boolean doInBackground(String... strings) {
                try {
                    credential = oAuthManager.authorize10a("plurk", null, null).getResult();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                token = credential.getAccessToken();
            }
        }.execute();

        return token;
    }

    private AuthorizationFlow setupAuthorizationFlow(ClientParametersAuthentication client) {
        if (credentialStore == null) {
            return null;
        }

        String requestTokenHost = "http://www.plurk.com/OAuth/request_token";
        String accessTokenHost = "http://www.plurk.com/OAuth/access_token";
        String authPageURL = "http://www.plurk.com/m/authorize";

        AuthorizationFlow.Builder flow = new AuthorizationFlow.Builder(
                BearerToken.authorizationHeaderAccessMethod(),
                AndroidHttp.newCompatibleTransport(),
                new JacksonFactory(),
                new GenericUrl(accessTokenHost),
                client,
                client.getClientId(),
                authPageURL);

        flow.setCredentialStore(credentialStore);
        flow.setTemporaryTokenRequestUrl(requestTokenHost);    // Plurk is OAuth 1.0a

        return flow.build();
    }

    private AuthorizationDialogController setupAuthDialog(FragmentManager fragmentManager) {

        AuthorizationDialogController controller = new DialogFragmentController(fragmentManager) {
            @Override
            public String getRedirectUri() throws IOException {
                return "http://localhost/Callback";
            }

            @Override
            public boolean isJavascriptEnabledForWebView() {
                return true;
            }
        };

        return controller;
    }

    public void setCredentialStore(SharePreferenceManager sharePreferenceManager) {
        credentialStore = sharePreferenceManager.getCredentialStore();
    }
}
