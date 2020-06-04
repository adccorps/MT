package com.mt.film.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * film实体类
 */
@Data //生成getter,setter等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
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
}
