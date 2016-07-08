package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class SchoolsEntity {
    private int schools_id;
    private String name;
    private String city;

    public int getSchools_id() {
        return schools_id;
    }

    public void setSchools_id(int schools_id) {
        this.schools_id = schools_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolsEntity that = (SchoolsEntity) o;

        if (schools_id != that.schools_id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return city != null ? city.equals(that.city) : that.city == null;

    }

    @Override
    public int hashCode() {
        int result = schools_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
