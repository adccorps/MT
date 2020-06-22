package com.mt.pojo.dto;

import com.mt.pojo.Film;
import io.swagger.annotations.ApiModel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ApiModel
public class FilmInfoDTO {
    private int filmInfoId;
    private String filmName;
    private Date releaseDate;
    private String actor;
    private String director;
    private String poster;
    private String introduction;
    private String[] type;
    private String language;
    private int duration;
    private List<Object> commentList;

    public FilmInfoDTO(Film film, String[] type, List<Object> commentList) {
           this.filmInfoId = film.getFilmId();
           this.filmName=film.getFilmName();
           this.releaseDate=film.getReleaseDate();
           this.actor=film.getActor();
           this.director=film.getDirector();
           this.poster=film.getPoster();
           this.introduction=film.getIntroduction();
           this.language=film.getLanguage();
           this.duration=film.getDuration();
           this.type=type;
           this.commentList=commentList;
    }

    public int getFilmInfoId() {
        return filmInfoId;
    }

    public void setFilmInfoId(int filmInfoId) {
        this.filmInfoId = filmInfoId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Object> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Object> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "FilmInfoDTO{" +
                "filmInfoId=" + filmInfoId +
                ", filmName='" + filmName + '\'' +
                ", releaseDate=" + releaseDate +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", poster='" + poster + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type=" + Arrays.toString(type) +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", commentList=" + commentList +
                '}';
    }
}
