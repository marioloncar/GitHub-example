package com.mario.githubexample.data.model.token;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("scope")
    private String scope;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("access_token")
    private String accessToken;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "scope='" + scope + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
