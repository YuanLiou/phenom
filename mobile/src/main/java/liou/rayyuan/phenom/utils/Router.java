package liou.rayyuan.phenom.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by louis383 on 2016/5/29.
 */

public class Router {

    private FragmentManager fragmentManager;

    public Router(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void addFragmentToActivity(Fragment fragment, int containerId, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerId, fragment, tag);
        transaction.commit();
    }
}
