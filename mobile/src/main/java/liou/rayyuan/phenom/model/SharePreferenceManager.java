package liou.rayyuan.phenom.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.api.client.json.jackson.JacksonFactory;
import com.wuman.android.auth.oauth2.store.SharedPreferencesCredentialStore;

/**
 * Created by louis383 on 16/3/26.
 */
public class SharePreferenceManager {

    private Context context;

    public SharePreferenceManager(Context context) {
        this.context = context;
    }

    public SharedPreferencesCredentialStore getCredentialStore() {
        SharedPreferencesCredentialStore credentialStore = new SharedPreferencesCredentialStore(context, "OAuth", new JacksonFactory());
        return credentialStore;
    }

    private SharedPreferences getSharePreference(String name) {
        return context.getSharedPreferences(name, 0);
    }
}
