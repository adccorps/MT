package com.mt.pojo;


import java.util.Date;
/**
 * film实体类
 */
public class Film {

    private int filmId;
    private String filmName;
    private Date createTime;
    private Date releaseDate;
    private String actor;
    private String director;
    private String poster;
    private String introduction;
    private String typeId;
    private String language;
    private int duration;

    public Film() {
        super();
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", createTime=" + createTime +
                ", releaseDate=" + releaseDate +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", poster='" + poster + '\'' +
                ", introduction='" + introduction + '\'' +
                ", typeId='" + typeId + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                '}';
    }

    public Film(int filmId, String filmName, Date createTime, Date releaseDate, String actor, String director, String poster, String introduction, String typeId, String language, int duration) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.createTime = createTime;
        this.releaseDate = releaseDate;
        this.actor = actor;
        this.director = director;
        this.poster = poster;
        this.introduction = introduction;
        this.typeId = typeId;
        this.language = language;
        this.duration = duration;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
}
