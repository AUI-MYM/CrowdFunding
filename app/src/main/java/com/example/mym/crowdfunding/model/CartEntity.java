package com.example.mym.crowdfunding.model;


import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class CartEntity {
    private int cartId;
    private int cartProjectsId;
    private int cartUsersId;
    private int sizeId;
    private Integer colorId;
    private Byte quantity;
    private Timestamp dateUpdate;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCartProjectsId() {
        return cartProjectsId;
    }

    public void setCartProjectsId(int cartProjectsId) {
        this.cartProjectsId = cartProjectsId;
    }

    public int getCartUsersId() {
        return cartUsersId;
    }

    public void setCartUsersId(int cartUsersId) {
        this.cartUsersId = cartUsersId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (cartId != that.cartId) return false;
        if (cartProjectsId != that.cartProjectsId) return false;
        if (cartUsersId != that.cartUsersId) return false;
        if (sizeId != that.sizeId) return false;
        if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        return dateUpdate != null ? dateUpdate.equals(that.dateUpdate) : that.dateUpdate == null;

    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + cartProjectsId;
        result = 31 * result + cartUsersId;
        result = 31 * result + sizeId;
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (dateUpdate != null ? dateUpdate.hashCode() : 0);
        return result;
    }
}
