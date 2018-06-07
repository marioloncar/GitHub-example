package com.mario.githubexample.data.model.repo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("received_events_url")
    private String receivedEventsUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @SerializedName("login")
    private String login;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("site_admin")
    private boolean siteAdmin;

    protected Owner(Parcel in) {
        id = in.readInt();
        receivedEventsUrl = in.readString();
        avatarUrl = in.readString();
        gravatarId = in.readString();
        login = in.readString();
        type = in.readString();
        url = in.readString();
        nodeId = in.readString();
        htmlUrl = in.readString();
        siteAdmin = in.readByte() != 0;
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(receivedEventsUrl);
        dest.writeString(avatarUrl);
        dest.writeString(gravatarId);
        dest.writeString(login);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(nodeId);
        dest.writeString(htmlUrl);
        dest.writeByte((byte) (siteAdmin ? 1 : 0));
    }
}
