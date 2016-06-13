package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class FollowersEntity {
    private int designerId;
    private int followerId;

    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowersEntity that = (FollowersEntity) o;

        if (designerId != that.designerId) return false;
        return followerId == that.followerId;

    }

    @Override
    public int hashCode() {
        int result = designerId;
        result = 31 * result + followerId;
        return result;
    }
}
