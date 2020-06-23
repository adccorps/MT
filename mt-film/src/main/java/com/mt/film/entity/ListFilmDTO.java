package com.mt.film.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel
public class ListFilmDTO {
    private String filmId;                  //电影的id
    private String filmName;              //电影的名字
    private String actor;                  //演员的名字
    private String poster;                 //图片
    private String director;                   //导演名称

    @Override
    public String toString() {
        return "ListFilmDTO{" +
                "filmId='" + filmId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", actor='" + actor + '\'' +
                ", poster='" + poster + '\'' +
                ", director='" + director + '\'' +
                '}';
    }

    public ListFilmDTO() {
        super();
    }

    public ListFilmDTO(String filmId, String filmName, String actor, String poster, String director) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.actor = actor;
        this.poster = poster;
        this.director = director;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
