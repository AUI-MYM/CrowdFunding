package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class TypeEntity {
    private int type_id;
    private String name;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
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

        TypeEntity that = (TypeEntity) o;

        if (type_id != that.type_id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = type_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
