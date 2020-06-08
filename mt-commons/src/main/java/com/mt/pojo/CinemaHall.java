package com.mt.pojo;

public class CinemaHall {
    private Integer hallId;
    private Integer cinemaId;
    private Integer maxSeat;
    private String  hallName;

    public CinemaHall() {
        super();
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(Integer maxSeat) {
        this.maxSeat = maxSeat;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public CinemaHall(Integer hallId, Integer cinemaId, Integer maxSeat, String hallName) {
        this.hallId = hallId;
        this.cinemaId = cinemaId;
        this.maxSeat = maxSeat;
        this.hallName = hallName;
    }
}
