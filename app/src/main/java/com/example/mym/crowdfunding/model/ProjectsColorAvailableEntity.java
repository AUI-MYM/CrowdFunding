package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsColorAvailableEntity {
    private int projectsId;
    private int colorId;

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsColorAvailableEntity that = (ProjectsColorAvailableEntity) o;

        if (projectsId != that.projectsId) return false;
        return colorId == that.colorId;

    }

    @Override
    public int hashCode() {
        int result = projectsId;
        result = 31 * result + colorId;
        return result;
    }
}
