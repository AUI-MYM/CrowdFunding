package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class CommentEntity {
    private int comments_id;
    private int comments_projects_id;
    private int comments_users_id;
    private String comment;
    private Timestamp date_create;

    public int getComments_id() {
        return comments_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public int getComments_projects_id() {
        return comments_projects_id;
    }

    public void setComments_projects_id(int comments_projects_id) {
        this.comments_projects_id = comments_projects_id;
    }

    public int getComments_users_id() {
        return comments_users_id;
    }

    public void setComments_users_id(int comments_users_id) {
        this.comments_users_id = comments_users_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (comments_id != that.comments_id) return false;
        if (comments_projects_id != that.comments_projects_id) return false;
        if (comments_users_id != that.comments_users_id) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return date_create != null ? date_create.equals(that.date_create) : that.date_create == null;

    }

    @Override
    public int hashCode() {
        int result = comments_id;
        result = 31 * result + comments_projects_id;
        result = 31 * result + comments_users_id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date_create != null ? date_create.hashCode() : 0);
        return result;
    }
}
