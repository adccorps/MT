package com.mt.comment.controller;


import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;
import com.mt.comment.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
     CommentService service;

    /**
     * 客户端-获取电影具体信息
     * 评论列表
     * */
    @GetMapping("/comment/{filmId}")
    public Object listComment(@PathVariable("filmId") Integer filmId) {
        //结果类封装
//        List<CommentDTO> commentDTOS = service.listComment(filmId);
        return service.listComment(filmId);
    }
    /**
     * 新增评论
     * */
    @PostMapping("/comment")
    public boolean insertComment(@RequestBody  Comment comment) {
        return service.insertComment(comment);
    }
    @GetMapping("/film/comment")
    public boolean isComment(Integer filmId, String customerId) {
        return service.isComment(filmId,customerId);
    }


}
