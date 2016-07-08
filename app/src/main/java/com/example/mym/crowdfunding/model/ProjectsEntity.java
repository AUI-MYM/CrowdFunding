package com.example.mym.crowdfunding.model;

import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.util.ServerConnector;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsEntity {
    private int projects_id;
    private int projects_users_id;
    private int projects_type_id;
    private String title;
    private String description;
    private Boolean gender;
    private String materials;
    private String wash_dry;
    private String other;
    private Double cost;
    private Integer color_id;
    private Double price;
    private Integer sale_minimum;
    private Integer sale_current;
    private Byte round;
    private Byte batch;
    private int projects_project_state_id;
    private Timestamp date_create;
    private Timestamp date_publish;
    private static long thirtydays = (long)30 * 24 * 60 * 60 * 1000;
    private static long oneday = (long)24 * 60 * 60 * 1000;

    public int getProjects_id() {
        return projects_id;
    }

    public void setProjects_id(int projects_id) {
        this.projects_id = projects_id;
    }

    public int getProjects_users_id() {
        return projects_users_id;
    }

    public void setProjects_users_id(int projects_users_id) {
        this.projects_users_id = projects_users_id;
    }

    public int getProjects_type_id() {
        return projects_type_id;
    }

    public void setProjects_type_id(int projects_type_id) {
        this.projects_type_id = projects_type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getWash_dry() {
        return wash_dry;
    }

    public void setWash_dry(String wash_dry) {
        this.wash_dry = wash_dry;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSale_minimum() {
        return sale_minimum;
    }

    public void setSale_minimum(Integer sale_minimum) {
        this.sale_minimum = sale_minimum;
    }

    public Integer getSale_current() {
        return sale_current;
    }

    public void setSale_current(Integer sale_current) {
        this.sale_current = sale_current;
    }

    public Byte getRound() {
        return round;
    }

    public void setRound(Byte round) {
        this.round = round;
    }

    public Byte getBatch() {
        return batch;
    }

    public void setBatch(Byte batch) {
        this.batch = batch;
    }

    public int getProjects_project_state_id() {
        return projects_project_state_id;
    }

    public void setProjects_project_state_id(int projects_project_state_id) {
        this.projects_project_state_id = projects_project_state_id;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    public Timestamp getDate_publish() {
        return date_publish;
    }

    public void setDate_publish(Timestamp date_publish) {
        this.date_publish = date_publish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (projects_id != that.projects_id) return false;
        if (projects_users_id != that.projects_users_id) return false;
        if (projects_type_id != that.projects_type_id) return false;
        if (projects_project_state_id != that.projects_project_state_id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (materials != null ? !materials.equals(that.materials) : that.materials != null)
            return false;
        if (wash_dry != null ? !wash_dry.equals(that.wash_dry) : that.wash_dry != null)
            return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (color_id != null ? !color_id.equals(that.color_id) : that.color_id != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sale_minimum != null ? !sale_minimum.equals(that.sale_minimum) : that.sale_minimum != null)
            return false;
        if (sale_current != null ? !sale_current.equals(that.sale_current) : that.sale_current != null)
            return false;
        if (round != null ? !round.equals(that.round) : that.round != null) return false;
        if (batch != null ? !batch.equals(that.batch) : that.batch != null) return false;
        if (date_create != null ? !date_create.equals(that.date_create) : that.date_create != null)
            return false;
        return date_publish != null ? date_publish.equals(that.date_publish) : that.date_publish == null;

    }

    @Override
    public int hashCode() {
        int result = projects_id;
        result = 31 * result + projects_users_id;
        result = 31 * result + projects_type_id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (materials != null ? materials.hashCode() : 0);
        result = 31 * result + (wash_dry != null ? wash_dry.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (color_id != null ? color_id.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sale_minimum != null ? sale_minimum.hashCode() : 0);
        result = 31 * result + (sale_current != null ? sale_current.hashCode() : 0);
        result = 31 * result + (round != null ? round.hashCode() : 0);
        result = 31 * result + (batch != null ? batch.hashCode() : 0);
        result = 31 * result + projects_project_state_id;
        result = 31 * result + (date_create != null ? date_create.hashCode() : 0);
        result = 31 * result + (date_publish != null ? date_publish.hashCode() : 0);
        return result;
    }

    public String get_poster_url() {
        return this.projects_id + "_1.jpg";
    }

    public String get_days_togo() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date_publish);
        cal.add(Calendar.DATE, 30);
        long diff = cal.getTimeInMillis() - now.getTime();
        if (diff > thirtydays) {
            return "0 day";
        } else if (diff > oneday) {
            return diff / oneday + " days";
        } else {
            return "1 day";
        }
    }

    public int getSalePercentage() {
        int percent = 100*sale_current/sale_minimum;
        return percent <= 100 ? percent : 100;
    }

    public String[] getImageURIList() {
        String base_url = ServerConnector.server_image_url +  projects_id + "_";
        return new String[]{base_url+"1.jpg", base_url+"2.jpg", base_url+"3.jpg", base_url+"4.jpg"};
    }
}
