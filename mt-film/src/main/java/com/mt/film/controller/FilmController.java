package com.mt.film.controller;

import com.mt.api.CommentApi;
import com.mt.film.entity.CommonResult;
import com.mt.film.entity.FilmDTO;
import com.mt.film.entity.FilmsDTO;
import com.mt.film.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class FilmController {
    @Resource
    private FilmService filmService;

    @Autowired
    CommentApi commentApi;

    /* *//*
    增加电影信息
     *//*
    @PostMapping(value = "/film/create")
    public CommonResult createFilm(@RequestBody Film film){
        int result = filmService.createFilm(film);
        log.info("********插入结果："+result);

        if(result>0){
            return  new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }*/
    /**
    根据id查询电影具体信息
     */
    @GetMapping(value = "/film/{film_id}")
    public FilmDTO getFilmById(@PathVariable("film_id") int id) {
        FilmDTO filmDTO = filmService.getFilmById(id); //获取原始dto
        String[] type_id = filmDTO.getType_id().split(",");
        String[] type = new String[type_id.length];
        int a;
        for (a = 0; a < type_id.length; a++) {               //根据type_id查出type
            type[a] = filmService.getTypeById(Integer.parseInt(type_id[a]));
        }
        //将type信息封装进filmDTO
        filmDTO.setType(type);
        //评论信息封装进DTO
        filmDTO.setCommentList((List) commentApi.listComment(filmDTO.getFilmId()));
        return filmDTO;
    }

    /**
     * 查询电影信息列表
     */
    @GetMapping(value = "/films")
    public List<FilmsDTO> getFilmById() {
        return filmService.getFilmList();
    }

    /**
     * 根据类型id查电影类型
     */
    public String getTypeById(@Param("type_id") int id) {
        return filmService.getTypeById(id);
    }

    ;
}
