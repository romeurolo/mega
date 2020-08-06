package org.academiadecodigo.mega.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Service;

@Service
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationDto {
    private Integer id;
    private String name;
    private String city;
    private String address;
    private String postalCode;
    private String phone;
    private double lat;
    private double longi;
    private Integer stamps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
