package liou.rayyuan.phenom.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by louis383 on 16/4/17.
 */
@Generated("org.jsonschema2pojo")
public abstract class _Plurk {

    @SerializedName("replurkers_count")
    @Expose
    private Integer replurkersCount;
    @SerializedName("replurkable")
    @Expose
    private Boolean replurkable;
    @SerializedName("favorite_count")
    @Expose
    private Integer favoriteCount;
    @SerializedName("is_unread")
    @Expose
    private Integer isUnread;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("plurk_type")
    @Expose
    private Integer plurkType;
    @SerializedName("qualifier_translated")
    @Expose
    private String qualifierTranslated;
    @SerializedName("replurked")
    @Expose
    private Boolean replurked;
    @SerializedName("replurker_id")
    @Expose
    private Object replurkerId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("qualifier")
    @Expose
    private String qualifier;
    @SerializedName("plurk_id")
    @Expose
    private Integer plurkId;
    @SerializedName("response_count")
    @Expose
    private Integer responseCount;
    @SerializedName("anonymous")
    @Expose
    private Boolean anonymous;
    @SerializedName("limited_to")
    @Expose
    private Object limitedTo;
    @SerializedName("no_comments")
    @Expose
    private Integer noComments;
    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;

    /**
     * @return The replurkersCount
     */
    public Integer getReplurkersCount() {
        return replurkersCount;
    }

    /**
     * @param replurkersCount The replurkers_count
     */
    public void setReplurkersCount(Integer replurkersCount) {
        this.replurkersCount = replurkersCount;
    }

    /**
     * @return The replurkable
     */
    public Boolean getReplurkable() {
        return replurkable;
    }

    /**
     * @param replurkable The replurkable
     */
    public void setReplurkable(Boolean replurkable) {
        this.replurkable = replurkable;
    }

    /**
     * @return The favoriteCount
     */
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * @param favoriteCount The favorite_count
     */
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * @return The isUnread
     */
    public Integer getIsUnread() {
        return isUnread;
    }

    /**
     * @param isUnread The is_unread
     */
    public void setIsUnread(Integer isUnread) {
        this.isUnread = isUnread;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return The plurkType
     */
    public Integer getPlurkType() {
        return plurkType;
    }

    /**
     * @param plurkType The plurk_type
     */
    public void setPlurkType(Integer plurkType) {
        this.plurkType = plurkType;
    }

    /**
     * @return The qualifierTranslated
     */
    public String getQualifierTranslated() {
        return qualifierTranslated;
    }

    /**
     * @param qualifierTranslated The qualifier_translated
     */
    public void setQualifierTranslated(String qualifierTranslated) {
        this.qualifierTranslated = qualifierTranslated;
    }

    /**
     * @return The replurked
     */
    public Boolean getReplurked() {
        return replurked;
    }

    /**
     * @param replurked The replurked
     */
    public void setReplurked(Boolean replurked) {
        this.replurked = replurked;
    }

    /**
     * @return The replurkerId
     */
    public Object getReplurkerId() {
        return replurkerId;
    }

    /**
     * @param replurkerId The replurker_id
     */
    public void setReplurkerId(Object replurkerId) {
        this.replurkerId = replurkerId;
    }

    /**
     * @return The ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId The owner_id
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return The qualifier
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * @param qualifier The qualifier
     */
    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    /**
     * @return The plurkId
     */
    public Integer getPlurkId() {
        return plurkId;
    }

    /**
     * @param plurkId The plurk_id
     */
    public void setPlurkId(Integer plurkId) {
        this.plurkId = plurkId;
    }

    /**
     * @return The responseCount
     */
    public Integer getResponseCount() {
        return responseCount;
    }

    /**
     * @param responseCount The response_count
     */
    public void setResponseCount(Integer responseCount) {
        this.responseCount = responseCount;
    }

    /**
     * @return The anonymous
     */
    public Boolean getAnonymous() {
        return anonymous;
    }

    /**
     * @param anonymous The anonymous
     */
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * @return The limitedTo
     */
    public Object getLimitedTo() {
        return limitedTo;
    }

    /**
     * @param limitedTo The limited_to
     */
    public void setLimitedTo(Object limitedTo) {
        this.limitedTo = limitedTo;
    }

    /**
     * @return The noComments
     */
    public Integer getNoComments() {
        return noComments;
    }

    /**
     * @param noComments The no_comments
     */
    public void setNoComments(Integer noComments) {
        this.noComments = noComments;
    }

    /**
     * @return The posted
     */
    public String getPosted() {
        return posted;
    }

    /**
     * @param posted The posted
     */
    public void setPosted(String posted) {
        this.posted = posted;
    }

    /**
     * @return The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return The favorite
     */
    public Boolean getFavorite() {
        return favorite;
    }

    /**
     * @param favorite The favorite
     */
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

}