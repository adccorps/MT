package com.mt.comment.dao;

import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    /**
     * 查询某电影的所有评论
     */
    List<CommentDTO> listComment(Integer filmId);

    /**
     * 新增评论
     */
    boolean insertComment(Comment comment);

    /**
     * 修改评论
     */
    boolean updateComment(Integer commentId,String content);

    /**
     * 获取一条评论
     */
    Comment getComment(Integer filmId,String customerId);

}
