package liou.rayyuan.phenom.model.domain;

import liou.rayyuan.phenom.model.entity._PlurkUsersDetail;
import liou.rayyuan.phenom.viewmodel.PlurkUserViewModel;

/**
 * Created by louis383 on 16/4/17.
 */
public class PlurkUsersDetail extends _PlurkUsersDetail {

    public PlurkUserViewModel getViewModel() {
        return new PlurkUserViewModel(this);
    }

}
