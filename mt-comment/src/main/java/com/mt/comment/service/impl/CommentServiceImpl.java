package com.mt.comment.service.impl;

import com.mt.comment.dao.CommentDao;
import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;
import com.mt.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    /**
     * 客户端-获取电影具体信息
     * 评论列表
     */
    @Override
    public List<CommentDTO> listComment(int filmId) {
        return commentDao.listComment(filmId);
    }

    /**
     * 新增评论
     */
    @Override
    public boolean insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public boolean updateComment(String commentId, String content) {
        return commentDao.updateComment(commentId, content);
    }


}
