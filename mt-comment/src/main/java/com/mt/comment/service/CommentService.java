package com.mt.comment.service;

import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;

import java.util.List;

public interface CommentService {


    /**
     * 查询某电影的所有评论
     */
    List<CommentDTO> listComment(int filmId);

    /**
     * 新增评论
     */
    boolean insertComment(Comment comment);

    /**
     * 修改评论
     */
    boolean updateComment(String commentId,String content);
}
