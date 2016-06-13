package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class ProjectsEntity {
    private int projectsId;
    private int projectsUsersId;
    private int projectsTypeId;
    private String title;
    private String description;
    private Boolean gender;
    private String materials;
    private String washDry;
    private String other;
    private Double cost;
    private Integer colorId;
    private Double price;
    private Integer saleMinimum;
    private Integer saleCurrent;
    private Byte round;
    private Byte batch;
    private int projectsProjectStateId;
    private Timestamp dateCreate;
    private Timestamp datePublish;

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public int getProjectsUsersId() {
        return projectsUsersId;
    }

    public void setProjectsUsersId(int projectsUsersId) {
        this.projectsUsersId = projectsUsersId;
    }

    public int getProjectsTypeId() {
        return projectsTypeId;
    }

    public void setProjectsTypeId(int projectsTypeId) {
        this.projectsTypeId = projectsTypeId;
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

    public String getWashDry() {
        return washDry;
    }

    public void setWashDry(String washDry) {
        this.washDry = washDry;
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

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSaleMinimum() {
        return saleMinimum;
    }

    public void setSaleMinimum(Integer saleMinimum) {
        this.saleMinimum = saleMinimum;
    }

    public Integer getSaleCurrent() {
        return saleCurrent;
    }

    public void setSaleCurrent(Integer saleCurrent) {
        this.saleCurrent = saleCurrent;
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

    public int getProjectsProjectStateId() {
        return projectsProjectStateId;
    }

    public void setProjectsProjectStateId(int projectsProjectStateId) {
        this.projectsProjectStateId = projectsProjectStateId;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Timestamp getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Timestamp datePublish) {
        this.datePublish = datePublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (projectsId != that.projectsId) return false;
        if (projectsUsersId != that.projectsUsersId) return false;
        if (projectsTypeId != that.projectsTypeId) return false;
        if (projectsProjectStateId != that.projectsProjectStateId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (materials != null ? !materials.equals(that.materials) : that.materials != null) return false;
        if (washDry != null ? !washDry.equals(that.washDry) : that.washDry != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (saleMinimum != null ? !saleMinimum.equals(that.saleMinimum) : that.saleMinimum != null) return false;
        if (saleCurrent != null ? !saleCurrent.equals(that.saleCurrent) : that.saleCurrent != null) return false;
        if (round != null ? !round.equals(that.round) : that.round != null) return false;
        if (batch != null ? !batch.equals(that.batch) : that.batch != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        return datePublish != null ? datePublish.equals(that.datePublish) : that.datePublish == null;

    }

    @Override
    public int hashCode() {
        int result = projectsId;
        result = 31 * result + projectsUsersId;
        result = 31 * result + projectsTypeId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (materials != null ? materials.hashCode() : 0);
        result = 31 * result + (washDry != null ? washDry.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (saleMinimum != null ? saleMinimum.hashCode() : 0);
        result = 31 * result + (saleCurrent != null ? saleCurrent.hashCode() : 0);
        result = 31 * result + (round != null ? round.hashCode() : 0);
        result = 31 * result + (batch != null ? batch.hashCode() : 0);
        result = 31 * result + projectsProjectStateId;
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (datePublish != null ? datePublish.hashCode() : 0);
        return result;
    }
}
