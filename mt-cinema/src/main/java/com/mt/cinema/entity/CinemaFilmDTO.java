package com.mt.cinema.entity;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CinemaFilmDTO {
    private Integer filmId;
    private String filmName;
    private String poster;
    private String duration;
    private String typeId;
    private String actor;

    public CinemaFilmDTO() {
        super();
    }

    @Override
    public String toString() {
        return "CinemaFilmDTO{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", poster='" + poster + '\'' +
                ", duration='" + duration + '\'' +
                ", typeId='" + typeId + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }

    public CinemaFilmDTO(Integer filmId, String filmName, String poster, String duration, String typeId, String actor) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.poster = poster;
        this.duration = duration;
        this.typeId = typeId;
        this.actor = actor;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
