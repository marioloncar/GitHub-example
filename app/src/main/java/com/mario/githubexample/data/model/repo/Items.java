package com.mario.githubexample.data.model.repo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Items implements Parcelable {

    @SerializedName("watchers_count")
    private int watchersCount;
    @SerializedName("fork")
    private boolean fork;
    @SerializedName("score")
    private float score;
    @SerializedName("master_branch")
    private String masterBranch;
    @SerializedName("open_issues_count")
    private int openIssuesCount;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("url")
    private String url;
    @SerializedName("size")
    private int size;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("private")
    private boolean privateRepo;
    @SerializedName("default_branch")
    private String defaultBranch;
    @SerializedName("id")
    private int id;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("stargazers_count")
    private int stargazersCount;
    @SerializedName("language")
    private String language;
    @SerializedName("forks_count")
    private int forksCount;
    @SerializedName("pushed_at")
    private String pushedAt;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("archived")
    private boolean archived;

    protected Items(Parcel in) {
        watchersCount = in.readInt();
        fork = in.readByte() != 0;
        score = in.readFloat();
        masterBranch = in.readString();
        openIssuesCount = in.readInt();
        homepage = in.readString();
        url = in.readString();
        size = in.readInt();
        nodeId = in.readString();
        privateRepo = in.readByte() != 0;
        defaultBranch = in.readString();
        id = in.readInt();
        htmlUrl = in.readString();
        updatedAt = in.readString();
        description = in.readString();
        name = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        createdAt = in.readString();
        stargazersCount = in.readInt();
        language = in.readString();
        forksCount = in.readInt();
        pushedAt = in.readString();
        fullName = in.readString();
        archived = in.readByte() != 0;
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getMasterBranch() {
        return masterBranch;
    }

    public void setMasterBranch(String masterBranch) {
        this.masterBranch = masterBranch;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public boolean isPrivateRepo() {
        return privateRepo;
    }

    public void setPrivateRepo(boolean privateRepo) {
        this.privateRepo = privateRepo;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return watchersCount == items.watchersCount &&
                fork == items.fork &&
                Float.compare(items.score, score) == 0 &&
                openIssuesCount == items.openIssuesCount &&
                size == items.size &&
                privateRepo == items.privateRepo &&
                id == items.id &&
                stargazersCount == items.stargazersCount &&
                forksCount == items.forksCount &&
                archived == items.archived &&
                Objects.equals(masterBranch, items.masterBranch) &&
                Objects.equals(homepage, items.homepage) &&
                Objects.equals(url, items.url) &&
                Objects.equals(nodeId, items.nodeId) &&
                Objects.equals(defaultBranch, items.defaultBranch) &&
                Objects.equals(htmlUrl, items.htmlUrl) &&
                Objects.equals(updatedAt, items.updatedAt) &&
                Objects.equals(description, items.description) &&
                Objects.equals(name, items.name) &&
                Objects.equals(owner, items.owner) &&
                Objects.equals(createdAt, items.createdAt) &&
                Objects.equals(language, items.language) &&
                Objects.equals(pushedAt, items.pushedAt) &&
                Objects.equals(fullName, items.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchersCount, fork, score, masterBranch, openIssuesCount, homepage, url, size, nodeId, privateRepo, defaultBranch, id, htmlUrl, updatedAt, description, name, owner, createdAt, stargazersCount, language, forksCount, pushedAt, fullName, archived);
    }

    @Override
    public String toString() {
        return "Items{" +
                "watchersCount=" + watchersCount +
                ", fork=" + fork +
                ", score=" + score +
                ", masterBranch='" + masterBranch + '\'' +
                ", openIssuesCount=" + openIssuesCount +
                ", homepage='" + homepage + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", nodeId='" + nodeId + '\'' +
                ", privateRepo=" + privateRepo +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", id=" + id +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", createdAt='" + createdAt + '\'' +
                ", stargazersCount=" + stargazersCount +
                ", language='" + language + '\'' +
                ", forksCount=" + forksCount +
                ", pushedAt='" + pushedAt + '\'' +
                ", fullName='" + fullName + '\'' +
                ", archived=" + archived +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(watchersCount);
        dest.writeByte((byte) (fork ? 1 : 0));
        dest.writeFloat(score);
        dest.writeString(masterBranch);
        dest.writeInt(openIssuesCount);
        dest.writeString(homepage);
        dest.writeString(url);
        dest.writeInt(size);
        dest.writeString(nodeId);
        dest.writeByte((byte) (privateRepo ? 1 : 0));
        dest.writeString(defaultBranch);
        dest.writeInt(id);
        dest.writeString(htmlUrl);
        dest.writeString(updatedAt);
        dest.writeString(description);
        dest.writeString(name);
        dest.writeParcelable(owner, flags);
        dest.writeString(createdAt);
        dest.writeInt(stargazersCount);
        dest.writeString(language);
        dest.writeInt(forksCount);
        dest.writeString(pushedAt);
        dest.writeString(fullName);
        dest.writeByte((byte) (archived ? 1 : 0));
    }
}
