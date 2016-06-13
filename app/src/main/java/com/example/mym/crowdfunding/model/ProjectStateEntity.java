package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectStateEntity {
    private int projectStateId;
    private String name;

    public int getProjectStateId() {
        return projectStateId;
    }

    public void setProjectStateId(int projectStateId) {
        this.projectStateId = projectStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectStateEntity that = (ProjectStateEntity) o;

        if (projectStateId != that.projectStateId) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = projectStateId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
