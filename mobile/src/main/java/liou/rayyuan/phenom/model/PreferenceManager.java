package liou.rayyuan.phenom.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by louis383 on 16/5/8.
 */
public class PreferenceManager {

    private final String preferenceName = "preference";
    private final String currentUserKey = "current_user";

    private SharedPreferences preferences;

    public PreferenceManager(Context context) {
        preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    public void setCurrentUser(String jsonString) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(currentUserKey, jsonString);
        editor.apply();
    }

    public void removeCurrentUser() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(currentUserKey, "");
        editor.apply();
    }

    public String getUserTokenString() {
        return preferences.getString(currentUserKey, "");
    }

}