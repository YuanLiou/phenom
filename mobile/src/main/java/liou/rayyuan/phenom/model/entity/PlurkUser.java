package liou.rayyuan.phenom.model.entity;

import java.util.Map;

import liou.rayyuan.phenom.model.domain.PlurkUsersDetail;

/**
 * Created by louis383 on 16/5/7.
 */
public class PlurkUser {

    private Map<String, PlurkUsersDetail> resultMap;

    public Map<String, PlurkUsersDetail> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, PlurkUsersDetail> resultMap) {
        this.resultMap = resultMap;
    }

}
