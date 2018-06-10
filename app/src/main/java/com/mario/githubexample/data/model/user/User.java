package com.mario.githubexample.data.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("login")
    private String login;
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("email")
    private String email;
    @SerializedName("bio")
    private String bio;
    @SerializedName("public_repos")
    private int publicRepos;
    @SerializedName("followers")
    private int followers;
    @SerializedName("created_at")
    private String createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                publicRepos == user.publicRepos &&
                followers == user.followers &&
                Objects.equals(avatarUrl, user.avatarUrl) &&
                Objects.equals(login, user.login) &&
                Objects.equals(name, user.name) &&
                Objects.equals(location, user.location) &&
                Objects.equals(email, user.email) &&
                Objects.equals(bio, user.bio) &&
                Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatarUrl, login, name, location, email, bio, publicRepos, followers, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", publicRepos=" + publicRepos +
                ", followers=" + followers +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
