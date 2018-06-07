package com.mario.githubexample.data.model.repo;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class GithubRepo {
    @SerializedName("incomplete_results")
    private boolean incompleteResults;
    @SerializedName("items")
    private List<Items> items;
    @SerializedName("total_count")
    private int totalCount;

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubRepo that = (GithubRepo) o;
        return incompleteResults == that.incompleteResults &&
                totalCount == that.totalCount &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incompleteResults, items, totalCount);
    }

    @Override
    public String toString() {
        return "GithubRepo{" +
                "incompleteResults=" + incompleteResults +
                ", items=" + items +
                ", totalCount=" + totalCount +
                '}';
    }
}


