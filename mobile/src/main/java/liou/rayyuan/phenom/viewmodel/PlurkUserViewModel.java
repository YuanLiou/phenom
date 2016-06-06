package liou.rayyuan.phenom.viewmodel;

import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;

/**
 * Created by louis383 on 2016/6/6.
 */

public class PlurkUserViewModel {

    private PlurkUsersDetail plurkUsers;

    public PlurkUserViewModel(PlurkUsersDetail plurkUsers) {
        this.plurkUsers = plurkUsers;
    }

    public String getUserDisplayName() {
        return plurkUsers.getDisplayName();
    }

    public String getUserId() {
        return plurkUsers.getId();
    }

}
