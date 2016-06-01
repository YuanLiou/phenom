package liou.rayyuan.phenom.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import liou.rayyuan.phenom.PhenomApplication;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.login.LoginActivity;
import liou.rayyuan.phenom.model.APIManager;

/**
 * Created by louis383 on 2016/6/1.
 */

public class TimelineFragment extends Fragment implements TimelineContract.View {

    public static final String TAG = "TIMELINE_FRAGMENT";

    private TimelineContract.Presenter presenter;
    private View layout;

    public TimelineFragment() {
    }

    public static TimelineFragment newInstance() {
        Bundle args = new Bundle();

        TimelineFragment fragment = new TimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        this.layout = view;

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(TimelineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openLoginPage() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivityForResult(intent, LoginActivity.OAUTH_LOGIN);
    }

    @Override
    public void setupAPIManager() {
        APIManager apiManager = ((PhenomApplication) getActivity().getApplication()).getApiManager();
        presenter.setAPIManager(apiManager);
    }

    @Override
    public void restoreAPIManager(String accessToken, String accessSecret) {
        ((PhenomApplication) getActivity().getApplication()).setApiManager(accessToken, accessSecret);
        APIManager apiManager = ((PhenomApplication) getActivity().getApplication()).getApiManager();
        presenter.setAPIManager(apiManager);
    }

    @Override
    public void makeSnackbar(String message) {
        Snackbar.make(layout, message, Snackbar.LENGTH_SHORT).show();
    }
}
