package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class OrdersEntity {
    private int orders_id;
    private int orders_users_id;
    private int orders_projects_id;
    private int size_id;
    private int color_id;
    private Byte quantity;
    private Timestamp date_create;
    private Integer orders_order_state_id;
    private int shipping_address_id;
    private Integer billing_address_id;

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getOrders_users_id() {
        return orders_users_id;
    }

    public void setOrders_users_id(int orders_users_id) {
        this.orders_users_id = orders_users_id;
    }

    public int getOrders_projects_id() {
        return orders_projects_id;
    }

    public void setOrders_projects_id(int orders_projects_id) {
        this.orders_projects_id = orders_projects_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    public Integer getOrders_order_state_id() {
        return orders_order_state_id;
    }

    public void setOrders_order_state_id(Integer orders_order_state_id) {
        this.orders_order_state_id = orders_order_state_id;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public Integer getBilling_address_id() {
        return billing_address_id;
    }

    public void setBilling_address_id(Integer billing_address_id) {
        this.billing_address_id = billing_address_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orders_id != that.orders_id) return false;
        if (orders_users_id != that.orders_users_id) return false;
        if (orders_projects_id != that.orders_projects_id) return false;
        if (size_id != that.size_id) return false;
        if (color_id != that.color_id) return false;
        if (shipping_address_id != that.shipping_address_id) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (date_create != null ? !date_create.equals(that.date_create) : that.date_create != null) return false;
        if (orders_order_state_id != null ? !orders_order_state_id.equals(that.orders_order_state_id) : that.orders_order_state_id != null)
            return false;
        return billing_address_id != null ? billing_address_id.equals(that.billing_address_id) : that.billing_address_id == null;

    }

    @Override
    public int hashCode() {
        int result = orders_id;
        result = 31 * result + orders_users_id;
        result = 31 * result + orders_projects_id;
        result = 31 * result + size_id;
        result = 31 * result + color_id;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (date_create != null ? date_create.hashCode() : 0);
        result = 31 * result + (orders_order_state_id != null ? orders_order_state_id.hashCode() : 0);
        result = 31 * result + shipping_address_id;
        result = 31 * result + (billing_address_id != null ? billing_address_id.hashCode() : 0);
        return result;
    }
}
