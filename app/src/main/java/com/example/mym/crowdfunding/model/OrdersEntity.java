package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class OrdersEntity {
    private int ordersId;
    private int ordersUsersId;
    private int ordersProjectsId;
    private int sizeId;
    private int colorId;
    private Byte quantity;
    private Timestamp dateCreate;
    private Integer ordersOrderStateId;
    private int shippingAddressId;
    private Integer billingAddressId;

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getOrdersUsersId() {
        return ordersUsersId;
    }

    public void setOrdersUsersId(int ordersUsersId) {
        this.ordersUsersId = ordersUsersId;
    }

    public int getOrdersProjectsId() {
        return ordersProjectsId;
    }

    public void setOrdersProjectsId(int ordersProjectsId) {
        this.ordersProjectsId = ordersProjectsId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getOrdersOrderStateId() {
        return ordersOrderStateId;
    }

    public void setOrdersOrderStateId(Integer ordersOrderStateId) {
        this.ordersOrderStateId = ordersOrderStateId;
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (ordersId != that.ordersId) return false;
        if (ordersUsersId != that.ordersUsersId) return false;
        if (ordersProjectsId != that.ordersProjectsId) return false;
        if (sizeId != that.sizeId) return false;
        if (colorId != that.colorId) return false;
        if (shippingAddressId != that.shippingAddressId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (ordersOrderStateId != null ? !ordersOrderStateId.equals(that.ordersOrderStateId) : that.ordersOrderStateId != null)
            return false;
        return billingAddressId != null ? billingAddressId.equals(that.billingAddressId) : that.billingAddressId == null;

    }

    @Override
    public int hashCode() {
        int result = ordersId;
        result = 31 * result + ordersUsersId;
        result = 31 * result + ordersProjectsId;
        result = 31 * result + sizeId;
        result = 31 * result + colorId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (ordersOrderStateId != null ? ordersOrderStateId.hashCode() : 0);
        result = 31 * result + shippingAddressId;
        result = 31 * result + (billingAddressId != null ? billingAddressId.hashCode() : 0);
        return result;
    }
}
