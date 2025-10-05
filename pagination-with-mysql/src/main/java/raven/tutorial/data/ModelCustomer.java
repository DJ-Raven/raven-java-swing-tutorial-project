package raven.tutorial.data;

import java.sql.Date;

public class ModelCustomer {

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ModelCustomer(int customerId, String firstName, String lastName, String company, String city, String country, String email, Date subscriptionDate, String website) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.city = city;
        this.country = country;
        this.email = email;
        this.subscriptionDate = subscriptionDate;
        this.website = website;
    }

    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String country;
    private String email;
    private Date subscriptionDate;
    private String website;


    public Object[] toTableRow(int row) {
        return new Object[]{row, firstName, lastName, country, city, country, email, subscriptionDate, website};
    }
}
