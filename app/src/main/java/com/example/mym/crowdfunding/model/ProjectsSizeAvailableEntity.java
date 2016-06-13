package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsSizeAvailableEntity {
    private int projectsId;
    private int sizeId;

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsSizeAvailableEntity that = (ProjectsSizeAvailableEntity) o;

        if (projectsId != that.projectsId) return false;
        return sizeId == that.sizeId;

    }

    @Override
    public int hashCode() {
        int result = projectsId;
        result = 31 * result + sizeId;
        return result;
    }
}
