package com.mt.comment.controller;


import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;
import com.mt.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object listComment(@PathVariable("filmId") int filmId) {
        //结果类封装
        List<CommentDTO> commentDTOS = service.listComment(filmId);
        return service.listComment(filmId);
    }
    /**
     * 新增评论
     * */
    @PostMapping("/comment")
    public boolean insertComment(Comment comment) {

        return service.insertComment(comment);
    }
}
