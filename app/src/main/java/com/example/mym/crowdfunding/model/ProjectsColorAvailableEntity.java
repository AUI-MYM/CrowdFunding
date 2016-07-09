package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsColorAvailableEntity {
    private int projects_id;
    private int color_id;

    public int getProjects_id() {
        return projects_id;
    }

    public void setProjects_id(int projects_id) {
        this.projects_id = projects_id;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsColorAvailableEntity that = (ProjectsColorAvailableEntity) o;

        if (projects_id != that.projects_id) return false;
        return color_id == that.color_id;

    }

    @Override
    public int hashCode() {
        int result = projects_id;
        result = 31 * result + color_id;
        return result;
    }
}
