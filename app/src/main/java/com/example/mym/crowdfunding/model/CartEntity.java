package com.example.mym.crowdfunding.model;


import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class CartEntity {
    private int cart_id;
    private int cart_projectsId;
    private int cart_usersId;
    private int size_id;
    private Integer color_id;
    private Byte quantity;
    private Timestamp date_update;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCart_projectsId() {
        return cart_projectsId;
    }

    public void setCart_projectsId(int cart_projectsId) {
        this.cart_projectsId = cart_projectsId;
    }

    public int getCart_usersId() {
        return cart_usersId;
    }

    public void setCart_usersId(int cart_usersId) {
        this.cart_usersId = cart_usersId;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDate_update() {
        return date_update;
    }

    public void setDate_update(Timestamp date_update) {
        this.date_update = date_update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (cart_id != that.cart_id) return false;
        if (cart_projectsId != that.cart_projectsId) return false;
        if (cart_usersId != that.cart_usersId) return false;
        if (size_id != that.size_id) return false;
        if (color_id != null ? !color_id.equals(that.color_id) : that.color_id != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        return date_update != null ? date_update.equals(that.date_update) : that.date_update == null;

    }

    @Override
    public int hashCode() {
        int result = cart_id;
        result = 31 * result + cart_projectsId;
        result = 31 * result + cart_usersId;
        result = 31 * result + size_id;
        result = 31 * result + (color_id != null ? color_id.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (date_update != null ? date_update.hashCode() : 0);
        return result;
    }
}
