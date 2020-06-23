package com.mt.film.controller;
import com.mt.film.service.FilmService;
import com.mt.film.entity.*;
import com.mt.pojo.Film;
import com.mt.pojo.dto.FilmInfoDTO;
import com.mt.pojo.FilmType;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class FilmController {
    @Resource
    private FilmService filmService;



    /**
     增加电影信息
     * */

    @PostMapping(value = "/film")
    public String createFilm(@RequestBody Film film){
        int result = filmService.createFilm(film);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }

    /**
     根据id查询电影具体信息
     */
    @GetMapping("/film/{filmId}")
    public FilmInfoDTO getFilmById(@PathVariable("filmId") int id) {

        return filmService.getFilmDTOById(id);
    }

    /**
     查询电影信息列表
     */
    @GetMapping(value = "/films")
    public List<ListFilmDTO> getFilmList() {
        return filmService.getFilmList();
    }

    /**
      更新电影信息
     */
    @PutMapping(value = "/film/{filmId}")
    public String updateFilm(@RequestBody Film film){
        int result =filmService.updateFilm(film);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }

    /**
     增加电影类型
     */
    @PostMapping(value = "/type")
    public String createType(@RequestBody FilmType filmType){
        int result =filmService.createType(filmType);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }

    /**
     根据类型id修改电影类型
     */
    @PutMapping(value = "/type/{typeId}")
    public String updateTypeById(@RequestBody FilmType filmType){
        int result =filmService.updateType(filmType);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
     查询所有类型信息（列表）
     */
    @GetMapping(value = "/types")
    public List<FilmType> getFilmTypeList(){
        return filmService.getFilmTypeList();
    }

}
