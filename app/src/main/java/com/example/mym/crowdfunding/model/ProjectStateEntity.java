package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectStateEntity {
    private int project_state_id;
    private String name;

    public int getProject_state_id() {
        return project_state_id;
    }

    public void setProject_state_id(int project_state_id) {
        this.project_state_id = project_state_id;
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

        if (project_state_id != that.project_state_id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = project_state_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
