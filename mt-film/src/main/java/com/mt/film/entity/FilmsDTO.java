package com.mt.film.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成getter,setter等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder

public class FilmsDTO {
    private	String	filmId;                  //电影的id
    private	String	 filmName;              //电影的名字
    private String	actor;                  //演员的名字
    private String	poster;                 //图片
    private String	director;                   //导演名称
}
