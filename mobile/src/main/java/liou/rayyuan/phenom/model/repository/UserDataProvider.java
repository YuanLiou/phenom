package liou.rayyuan.phenom.model.repository;

import java.util.HashMap;
import java.util.Map;

import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;

/**
 * Created by louis383 on 2016/6/15.
 */

public class UserDataProvider {
    private Map<String, PlurkUsersDetail> user;

    public UserDataProvider() {
        this(null);
    }

    public UserDataProvider(Map<String, PlurkUsersDetail> user) {
        if (user == null) {
            user = new HashMap<>();
        }

        setupUser(user);
    }

    public void setupUser(Map<String, PlurkUsersDetail> user) {
        this.user = user;
    }

    public void addUsers(Map<String, PlurkUsersDetail> user) {
        this.user.putAll(user);
    }

    public void updateUser(String id, PlurkUsersDetail detail) {
        this.user.put(id, detail);
    }

    public PlurkUsersDetail getUserDetail(String id) {
        return this.user.get(id);
    }

    public boolean hasUserDetail(String id) {
        return this.user.containsKey(id);
    }

    public int getCount() {
        return this.user.size();
    }

    public boolean isEmpty() {
        return this.user.isEmpty();
    }
}
