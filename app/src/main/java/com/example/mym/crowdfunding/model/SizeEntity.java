package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class SizeEntity {
    private int size_id;
    private String name;

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
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

        SizeEntity that = (SizeEntity) o;

        if (size_id != that.size_id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = size_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
