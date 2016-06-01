package liou.rayyuan.phenom.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import liou.rayyuan.phenom.PhenomApplication;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.model.CurrentUserManager;
import liou.rayyuan.phenom.model.PreferenceManager;
import liou.rayyuan.phenom.utils.Router;

/**
 * Created by louis383 on 2016/5/28.
 */

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        TimelineFragment fragment = (TimelineFragment) getSupportFragmentManager().findFragmentById(R.id.main_content);
        if (fragment == null) {
            fragment = TimelineFragment.newInstance();

            Router router = new Router(getSupportFragmentManager());
            router.addFragmentToActivity(fragment, R.id.main_content, TimelineFragment.TAG);
        }

        PreferenceManager preferenceManager = ((PhenomApplication) getApplication()).getPreferenceManager();
        CurrentUserManager currentUserManager = ((PhenomApplication) getApplication()).getCurrentUserManager(preferenceManager);

        new TimelinePresenter(currentUserManager, fragment);
    }
}
