package liou.rayyuan.phenom.model.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import liou.rayyuan.phenom.model.entity.PlurkUser;

/**
 * Created by louis383 on 16/4/17.
 */
@Generated("org.jsonschema2pojo")
public class Page {

    @SerializedName("plurk_users")
    @Expose
    private PlurkUser plurkUsers;
    @SerializedName("plurks")
    @Expose
    private List<Plurk> plurks = new ArrayList<Plurk>();

    public PlurkUser getPlurkUsers() {
        return plurkUsers;
    }

    /**
     * @return The plurks
     */
    public List<Plurk> getPlurks() {
        return plurks;
    }
}