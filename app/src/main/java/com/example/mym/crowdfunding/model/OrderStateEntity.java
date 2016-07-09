package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class OrderStateEntity {
    private int order_state_id;
    private String name;

    public int getOrder_state_id() {
        return order_state_id;
    }

    public void setOrder_state_id(int order_state_id) {
        this.order_state_id = order_state_id;
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

        OrderStateEntity that = (OrderStateEntity) o;

        if (order_state_id != that.order_state_id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = order_state_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
