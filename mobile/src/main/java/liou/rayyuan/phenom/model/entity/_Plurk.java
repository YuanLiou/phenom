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
    private int replurkersCount;
    @SerializedName("replurkable")
    @Expose
    private boolean replurkable;
    @SerializedName("favorite_count")
    @Expose
    private int favoriteCount;
    @SerializedName("is_unread")
    @Expose
    private int isUnread;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("plurk_type")
    @Expose
    private int plurkType;
    @SerializedName("qualifier_translated")
    @Expose
    private String qualifierTranslated;
    @SerializedName("replurked")
    @Expose
    private boolean replurked;
    @SerializedName("replurker_id")
    @Expose
    private String replurkerId;
    @SerializedName("owner_id")
    @Expose
    private String ownerId;
    @SerializedName("qualifier")
    @Expose
    private String qualifier;
    @SerializedName("plurk_id")
    @Expose
    private String plurkId;
    @SerializedName("response_count")
    @Expose
    private int responseCount;
    @SerializedName("anonymous")
    @Expose
    private boolean anonymous;
    @SerializedName("limited_to")
    @Expose
    private Object limitedTo;
    @SerializedName("no_comments")
    @Expose
    private int noComments;
    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("favorite")
    @Expose
    private boolean favorite;

    /**
     * @return The replurkersCount
     */
    public int getReplurkersCount() {
        return replurkersCount;
    }

    /**
     * @param replurkersCount The replurkers_count
     */
    public void setReplurkersCount(int replurkersCount) {
        this.replurkersCount = replurkersCount;
    }

    /**
     * @return The replurkable
     */
    public boolean getReplurkable() {
        return replurkable;
    }

    /**
     * @param replurkable The replurkable
     */
    public void setReplurkable(boolean replurkable) {
        this.replurkable = replurkable;
    }

    /**
     * @return The favoriteCount
     */
    public int getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * @param favoriteCount The favorite_count
     */
    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * @return The isUnread
     */
    public int getIsUnread() {
        return isUnread;
    }

    /**
     * @param isUnread The is_unread
     */
    public void setIsUnread(int isUnread) {
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
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The plurkType
     */
    public int getPlurkType() {
        return plurkType;
    }

    /**
     * @param plurkType The plurk_type
     */
    public void setPlurkType(int plurkType) {
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
    public boolean getReplurked() {
        return replurked;
    }

    /**
     * @param replurked The replurked
     */
    public void setReplurked(boolean replurked) {
        this.replurked = replurked;
    }

    /**
     * @return The replurkerId
     */
    public String getReplurkerId() {
        return replurkerId;
    }

    /**
     * @param replurkerId The replurker_id
     */
    public void setReplurkerId(String replurkerId) {
        this.replurkerId = replurkerId;
    }

    /**
     * @return The ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId The owner_id
     */
    public void setOwnerId(String ownerId) {
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
    public String getPlurkId() {
        return plurkId;
    }

    /**
     * @param plurkId The plurk_id
     */
    public void setPlurkId(String plurkId) {
        this.plurkId = plurkId;
    }

    /**
     * @return The responseCount
     */
    public int getResponseCount() {
        return responseCount;
    }

    /**
     * @param responseCount The response_count
     */
    public void setResponseCount(int responseCount) {
        this.responseCount = responseCount;
    }

    /**
     * @return The anonymous
     */
    public boolean getAnonymous() {
        return anonymous;
    }

    /**
     * @param anonymous The anonymous
     */
    public void setAnonymous(boolean anonymous) {
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
    public int getNoComments() {
        return noComments;
    }

    /**
     * @param noComments The no_comments
     */
    public void setNoComments(int noComments) {
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
    public boolean getFavorite() {
        return favorite;
    }

    /**
     * @param favorite The favorite
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}