package com.example.mym.crowdfunding.model;

import java.sql.Timestamp;

/**
 * Created by Mert on 6/11/2016.
 */
public class UsersEntity {
    private int users_id;
    private int users_groups_id;
    private String email;
    private String about;
    private Integer schools_id;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String website;
    private Timestamp date_create;
    private String address_label;
    private String street;
    private String additional_info;
    private String company;
    private String country;
    private String city;
    private String zip_code;
    private Integer shipping_address_id;
    private Integer billing_address_id;

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getUsers_groups_id() {
        return users_groups_id;
    }

    public void setUsers_groups_id(int users_groups_id) {
        this.users_groups_id = users_groups_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getSchools_id() {
        return schools_id;
    }

    public void setSchools_id(Integer schools_id) {
        this.schools_id = schools_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    public String getAddress_label() {
        return address_label;
    }

    public void setAddress_label(String address_label) {
        this.address_label = address_label;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public Integer getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(Integer shipping_address_id) {
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

        UsersEntity that = (UsersEntity) o;

        if (users_id != that.users_id) return false;
        if (users_groups_id != that.users_groups_id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        if (schools_id != null ? !schools_id.equals(that.schools_id) : that.schools_id != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (date_create != null ? !date_create.equals(that.date_create) : that.date_create != null) return false;
        if (address_label != null ? !address_label.equals(that.address_label) : that.address_label != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (additional_info != null ? !additional_info.equals(that.additional_info) : that.additional_info != null)
            return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (zip_code != null ? !zip_code.equals(that.zip_code) : that.zip_code != null) return false;
        if (shipping_address_id != null ? !shipping_address_id.equals(that.shipping_address_id) : that.shipping_address_id != null)
            return false;
        return billing_address_id != null ? billing_address_id.equals(that.billing_address_id) : that.billing_address_id == null;

    }

    @Override
    public int hashCode() {
        int result = users_id;
        result = 31 * result + users_groups_id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (schools_id != null ? schools_id.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (date_create != null ? date_create.hashCode() : 0);
        result = 31 * result + (address_label != null ? address_label.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (additional_info != null ? additional_info.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip_code != null ? zip_code.hashCode() : 0);
        result = 31 * result + (shipping_address_id != null ? shipping_address_id.hashCode() : 0);
        result = 31 * result + (billing_address_id != null ? billing_address_id.hashCode() : 0);
        return result;
    }
}
