package liou.rayyuan.phenom.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by louis383 on 16/4/10.
 */
@Generated("org.jsonschema2pojo")
public class _Token {

    @SerializedName("oauth_nonce")
    @Expose
    private String oauthNonce;
    @SerializedName("oauth_timestamp")
    @Expose
    private String oauthTimestamp;
    @SerializedName("oauth_consumer_key")
    @Expose
    private String oauthConsumerKey;
    @SerializedName("oauth_signature_method")
    @Expose
    private String oauthSignatureMethod;
    @SerializedName("oauth_version")
    @Expose
    private String oauthVersion;
    @SerializedName("oauth_signature")
    @Expose
    private String oauthSignature;
    @SerializedName("oauth_token_secret")
    @Expose
    private String oauthTokenSecret;
    @SerializedName("oauth_verifier")
    @Expose
    private String oauthVerifier;
    @SerializedName("oauth_token")
    @Expose
    private String oauthToken;

    /**
     * @return The oauthNonce
     */
    public String getOauthNonce() {
        return oauthNonce;
    }

    /**
     * @param oauthNonce The oauth_nonce
     */
    public void setOauthNonce(String oauthNonce) {
        this.oauthNonce = oauthNonce;
    }

    /**
     * @return The oauthTimestamp
     */
    public String getOauthTimestamp() {
        return oauthTimestamp;
    }

    /**
     * @param oauthTimestamp The oauth_timestamp
     */
    public void setOauthTimestamp(String oauthTimestamp) {
        this.oauthTimestamp = oauthTimestamp;
    }

    /**
     * @return The oauthConsumerKey
     */
    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    /**
     * @param oauthConsumerKey The oauth_consumer_key
     */
    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    /**
     * @return The oauthSignatureMethod
     */
    public String getOauthSignatureMethod() {
        return oauthSignatureMethod;
    }

    /**
     * @param oauthSignatureMethod The oauth_signature_method
     */
    public void setOauthSignatureMethod(String oauthSignatureMethod) {
        this.oauthSignatureMethod = oauthSignatureMethod;
    }

    /**
     * @return The oauthVersion
     */
    public String getOauthVersion() {
        return oauthVersion;
    }

    /**
     * @param oauthVersion The oauth_version
     */
    public void setOauthVersion(String oauthVersion) {
        this.oauthVersion = oauthVersion;
    }

    /**
     * @return The oauthSignature
     */
    public String getOauthSignature() {
        return oauthSignature;
    }

    /**
     * @param oauthSignature The oauth_signature
     */
    public void setOauthSignature(String oauthSignature) {
        this.oauthSignature = oauthSignature;
    }

    /**
     * @return The oauthTokenSecret
     */
    public String getOauthTokenSecret() {
        return oauthTokenSecret;
    }

    /**
     * @param oauthTokenSecret The oauth_token_secret
     */
    public void setOauthTokenSecret(String oauthTokenSecret) {
        this.oauthTokenSecret = oauthTokenSecret;
    }

    /**
     * @return The oauthVerifier
     */
    public String getOauthVerifier() {
        return oauthVerifier;
    }

    /**
     * @param oauthVerifier The oauth_verifier
     */
    public void setOauthVerifier(String oauthVerifier) {
        this.oauthVerifier = oauthVerifier;
    }

    /**
     * @return The oauthToken
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * @param oauthToken The oauth_token
     */
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

}
