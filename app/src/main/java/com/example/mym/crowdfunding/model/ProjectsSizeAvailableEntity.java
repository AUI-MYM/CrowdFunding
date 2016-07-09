package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsSizeAvailableEntity {
    private int projects_id;
    private int size_id;

    public int getProjects_id() {
        return projects_id;
    }

    public void setProjects_id(int projects_id) {
        this.projects_id = projects_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsSizeAvailableEntity that = (ProjectsSizeAvailableEntity) o;

        if (projects_id != that.projects_id) return false;
        return size_id == that.size_id;

    }

    @Override
    public int hashCode() {
        int result = projects_id;
        result = 31 * result + size_id;
        return result;
    }
}
