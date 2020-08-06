package org.academiadecodigo.mega.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location extends AbstractModel {
    private String name;
    private String city;
    private String address;
    private String postalCode;
    private String phone;
    private double lat;
    private double longi;
    private Integer stamps;


        @OneToMany(
                // propagate changes on customer entity to account entities
                cascade = {CascadeType.ALL},

                // make sure to remove accounts if unlinked from customer
                orphanRemoval = true,

                // user customer foreign key on account table to establish
                // the many-to-one relationship instead of a join table
                mappedBy = "location",

                // fetch accounts from database together with user
                fetch = FetchType.EAGER
        )
        private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        reviews.add(review);
        review.setLocation(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public Integer getStamps() {
        return stamps;
    }

    public void setStamps(Integer stamps) {
        this.stamps = stamps;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "Location{" +
                "Name='" + name + '\'' +
                ", City='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postal Code='" + postalCode + '\'' +
                ", Telephone='" + phone + '\'' +
                ", stamps=" + stamps +
                "} " + super.toString();
    }

}
