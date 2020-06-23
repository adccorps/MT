package com.mt.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Cinema {
    private  int cinemaId;
    private  String cinemaName;
    private  String address;
    private  String phone;

    public Cinema() {
        super();
    }

    public Cinema(int cinemaId, String cinemaName, String address, String phone) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.phone = phone;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
