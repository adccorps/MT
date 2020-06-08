package com.mt.cinema.entity;

public class CinemaHallDTO {
    private Integer hallId;
    private String hallName;

    public CinemaHallDTO() {
        super();
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public CinemaHallDTO(Integer hallId, String hallName) {
        this.hallId = hallId;
        this.hallName = hallName;
    }
}
