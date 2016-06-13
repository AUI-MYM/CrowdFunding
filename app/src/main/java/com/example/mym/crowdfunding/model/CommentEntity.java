package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class CommentEntity {
    private int commentsId;
    private int commentsProjectsId;
    private int commentsUsersId;
    private String comment;
    private Timestamp dateCreate;

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public int getCommentsProjectsId() {
        return commentsProjectsId;
    }

    public void setCommentsProjectsId(int commentsProjectsId) {
        this.commentsProjectsId = commentsProjectsId;
    }

    public int getCommentsUsersId() {
        return commentsUsersId;
    }

    public void setCommentsUsersId(int commentsUsersId) {
        this.commentsUsersId = commentsUsersId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentsId != that.commentsId) return false;
        if (commentsProjectsId != that.commentsProjectsId) return false;
        if (commentsUsersId != that.commentsUsersId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return dateCreate != null ? dateCreate.equals(that.dateCreate) : that.dateCreate == null;

    }

    @Override
    public int hashCode() {
        int result = commentsId;
        result = 31 * result + commentsProjectsId;
        result = 31 * result + commentsUsersId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        return result;
    }
}
