package com.mt.admin.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@ApiModel
public class CinemaDTO {
    private  Integer cinemaId;
    private  String cinemaName;
    private  String address;
    private Double price;

    @Override
    public String toString() {
        return "CinemaDTO{" +
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }

    public CinemaDTO() {
        super();
    }

    public CinemaDTO(Integer cinemaId, String cinemaName, String address, Double price) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.price = price;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
