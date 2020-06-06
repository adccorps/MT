package com.mt.pojo;

public class CinemaFilm {
    private Integer id;
    private Integer filmId;
    private Integer cinemaId;
    private Integer isShow;

    @Override
    public String toString() {
        return "CinemaFilm{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", cinemaId=" + cinemaId +
                ", isShow=" + isShow +
                '}';
    }

    public CinemaFilm() {
        super();
    }

    public CinemaFilm(Integer id, Integer filmId, Integer cinemaId, Integer isShow) {
        this.id = id;
        this.filmId = filmId;
        this.cinemaId = cinemaId;
        this.isShow = isShow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}
