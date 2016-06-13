package com.example.mym.crowdfunding.model;


/**
 * Created by Mert on 6/11/2016.
 */
public class UsersAddressEntity {
    private int usersId;
    private int addressId;

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAddressEntity that = (UsersAddressEntity) o;

        if (usersId != that.usersId) return false;
        return addressId == that.addressId;

    }

    @Override
    public int hashCode() {
        int result = usersId;
        result = 31 * result + addressId;
        return result;
    }
}
