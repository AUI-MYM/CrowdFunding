package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class PaymentEntity {
    private int payment_id;
    private String cardholder;
    private Integer payment_type_id;
    private String account;
    private Byte month;
    private Byte year;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public Integer getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(Integer payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getYear() {
        return year;
    }

    public void setYear(Byte year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (payment_id != that.payment_id) return false;
        if (cardholder != null ? !cardholder.equals(that.cardholder) : that.cardholder != null) return false;
        if (payment_type_id != null ? !payment_type_id.equals(that.payment_type_id) : that.payment_type_id != null)
            return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        return year != null ? year.equals(that.year) : that.year == null;

    }

    @Override
    public int hashCode() {
        int result = payment_id;
        result = 31 * result + (cardholder != null ? cardholder.hashCode() : 0);
        result = 31 * result + (payment_type_id != null ? payment_type_id.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
