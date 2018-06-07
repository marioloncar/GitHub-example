package com.mario.githubexample.data.model.repo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Owner {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id &&
                Objects.equals(receivedEventsUrl, owner.receivedEventsUrl) &&
                Objects.equals(avatarUrl, owner.avatarUrl) &&
                Objects.equals(gravatarId, owner.gravatarId) &&
                Objects.equals(login, owner.login) &&
                Objects.equals(type, owner.type) &&
                Objects.equals(url, owner.url) &&
                Objects.equals(nodeId, owner.nodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receivedEventsUrl, avatarUrl, gravatarId, login, type, url, nodeId);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", login='" + login + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", nodeId='" + nodeId + '\'' +
                '}';
    }
}
