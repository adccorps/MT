package com.mt.film.controller;
import com.mt.film.service.FilmService;
import com.mt.film.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class FilmController {
    @Resource
    private FilmService filmService;


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
    @GetMapping("/film/{id}")
    public FilmInfoDTO getFilmById(@PathVariable("id") int id) {

        return filmService.getFilmDTOById(id);
    }

    /**
     * 查询电影信息列表
     */
    @GetMapping(value = "/films")
    public List<ListFilmDTO> getFilmById() {
        return filmService.getFilmList();
    }

    /**
     * 根据类型id查电影类型
     */
    public String getTypeById(@Param("type_id") int id) {
        return filmService.getTypeById(id);
    }


}
