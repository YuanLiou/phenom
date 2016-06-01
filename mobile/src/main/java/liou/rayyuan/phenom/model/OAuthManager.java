package liou.rayyuan.phenom.model;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import liou.rayyuan.phenom.BuildConfig;
import liou.rayyuan.phenom.model.domain.Token;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

/**
 * Created by louis383 on 16/4/10.
 * Use this class to request Plurk's OAuth 1.0a Consumer key and secret
 */
public class OAuthManager {

    public static final String URL_STARTWITH = "oauth";

    private String requestTokenEndpoint = "http://www.plurk.com/OAuth/request_token";
    private String accessTokenEndpoint = "http://www.plurk.com/OAuth/access_token";
    private String authorizationUrl = "http://www.plurk.com/m/authorize";
    private String oauthCallback = "oauth://plurk";
    private DefaultOAuthProvider provider;
    private DefaultOAuthConsumer consumer;
    private Token userToken;

    private oAuthCallback callback;

    public OAuthManager(oAuthCallback callback) {
        this.callback = callback;
        userToken = new Token();
    }

    public void initPlurkRequestKey() {
        consumer = new DefaultOAuthConsumer(BuildConfig.PLURK_APPKEY, BuildConfig.PLURK_APPSECRET);
        provider = new DefaultOAuthProvider(requestTokenEndpoint, accessTokenEndpoint, authorizationUrl);

        new AsyncTask<Void, Void, Void>() {
            String authUrl = "";
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    authUrl = provider.retrieveRequestToken(consumer, oauthCallback);
                } catch (OAuthMessageSignerException | OAuthCommunicationException |
                        OAuthExpectationFailedException | OAuthNotAuthorizedException messageSigner) {
                    callback.onOAuthLoginError(messageSigner.getMessage());
                    messageSigner.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (!TextUtils.isEmpty(authUrl)) {
                    callback.onReceivedRequestKey(authUrl);
                }
            }
        }.execute();
    }

    public void initPlurkAccessKey(final Uri uri) {
        new AsyncTask<Void, Void, Void>() {
            String token = "";
            String tokenSecret = "";

            @Override
            protected Void doInBackground(Void... params) {
                String pinCode = uri.getQueryParameter("oauth_verifier");
                try {
                    provider.retrieveAccessToken(consumer, pinCode);
                    token = consumer.getToken();
                    tokenSecret = consumer.getTokenSecret();

                    userToken.setOauthToken(consumer.getToken());
                    userToken.setOauthTokenSecret(consumer.getTokenSecret());
                    userToken.setOauthConsumerKey(consumer.getConsumerKey());
                } catch (OAuthMessageSignerException | OAuthNotAuthorizedException |
                        OAuthExpectationFailedException | OAuthCommunicationException messageSigner) {
                    callback.onOAuthLoginError(messageSigner.getMessage());
                    messageSigner.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (!token.isEmpty() && !tokenSecret.isEmpty()) {
                    callback.onReceivedAccessKey(token, tokenSecret, userToken);
                }
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    public interface oAuthCallback {
        void onReceivedRequestKey(String url);
        void onReceivedAccessKey(String accessKey, String accessSecret, Token userToken);
        void onOAuthLoginError(String errorMessage);
    }
}


