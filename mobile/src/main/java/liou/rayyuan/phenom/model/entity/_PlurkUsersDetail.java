package liou.rayyuan.phenom.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by louis383 on 16/4/17.
 */

@Generated("org.jsonschema2pojo")
public abstract class _PlurkUsersDetail {

    @SerializedName("verified_account")
    @Expose
    private boolean verifiedAccount;
    @SerializedName("default_lang")
    @Expose
    private String defaultLang;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("dateformat")
    @Expose
    private int dateformat;
    @SerializedName("has_profile_image")
    @Expose
    private int hasProfileImage;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("name_color")
    @Expose
    private String nameColor;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timeline_privacy")
    @Expose
    private int timelinePrivacy;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("nick_name")
    @Expose
    private String nickName;
    @SerializedName("gender")
    @Expose
    private int gender;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("background_id")
    @Expose
    private int backgroundId;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("avatar")
    @Expose
    private int avatar;
    @SerializedName("bday_privacy")
    @Expose
    private int bdayPrivacy;
    @SerializedName("karma")
    @Expose
    private double karma;

    /**
     * @return The verifiedAccount
     */
    public boolean getVerifiedAccount() {
        return verifiedAccount;
    }

    /**
     * @param verifiedAccount The verified_account
     */
    public void setVerifiedAccount(boolean verifiedAccount) {
        this.verifiedAccount = verifiedAccount;
    }

    /**
     * @return The defaultLang
     */
    public String getDefaultLang() {
        return defaultLang;
    }

    /**
     * @param defaultLang The default_lang
     */
    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    /**
     * @return The premium
     */
    public boolean getPremium() {
        return premium;
    }


    /**
     * @param premium The premium
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * @return The dateformat
     */
    public int getDateformat() {
        return dateformat;
    }

    /**
     * @param dateformat The dateformat
     */
    public void setDateformat(int dateformat) {
        this.dateformat = dateformat;
    }

    /**
     * @return The hasProfileImage
     */
    public int getHasProfileImage() {
        return hasProfileImage;
    }

    /**
     * @param hasProfileImage The has_profile_image
     */
    public void setHasProfileImage(int hasProfileImage) {
        this.hasProfileImage = hasProfileImage;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return The nameColor
     */
    public String getNameColor() {
        return nameColor;
    }

    /**
     * @param nameColor The name_color
     */
    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    /**
     * @return The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * @return The timelinePrivacy
     */
    public int getTimelinePrivacy() {
        return timelinePrivacy;
    }

    /**
     * @param timelinePrivacy The timeline_privacy
     */
    public void setTimelinePrivacy(int timelinePrivacy) {
        this.timelinePrivacy = timelinePrivacy;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return The nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName The nick_name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return The gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * @return The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return The backgroundId
     */
    public int getBackgroundId() {
        return backgroundId;
    }

    /**
     * @param backgroundId The background_id
     */
    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    /**
     * @return The dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth The date_of_birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return The avatar
     */
    public int getAvatar() {
        return avatar;
    }

    /**
     * @param avatar The avatar
     */
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    /**
     * @return The bdayPrivacy
     */
    public int getBdayPrivacy() {
        return bdayPrivacy;
    }

    /**
     * @param bdayPrivacy The bday_privacy
     */
    public void setBdayPrivacy(int bdayPrivacy) {
        this.bdayPrivacy = bdayPrivacy;
    }

    /**
     * @return The karma
     */
    public double getKarma() {
        return karma;
    }

    /**
     * @param karma The karma
     */
    public void setKarma(double karma) {
        this.karma = karma;
    }

}
