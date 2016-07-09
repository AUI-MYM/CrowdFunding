package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class FollowersEntity {
    private int designer_id;
    private int follower_id;

    public int getDesigner_id() {
        return designer_id;
    }

    public void setDesigner_id(int designer_id) {
        this.designer_id = designer_id;
    }

    public int getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowersEntity that = (FollowersEntity) o;

        if (designer_id != that.designer_id) return false;
        return follower_id == that.follower_id;

    }

    @Override
    public int hashCode() {
        int result = designer_id;
        result = 31 * result + follower_id;
        return result;
    }
}
