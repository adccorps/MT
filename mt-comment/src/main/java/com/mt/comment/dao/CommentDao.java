package com.mt.comment.dao;

import com.mt.pojo.Comment;
import com.mt.comment.pojo.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    /**
     * 查询某电影的所有评论
     */
    List<CommentDTO> listComment(@Param("filmId")Integer filmId);

    /**
     * 新增评论
     */
    boolean insertComment(@Param("comment") Comment comment);

    /**
     * 修改评论
     */
    boolean updateComment(@Param("commentId")Integer commentId, @Param("content")String content);

    /**
     * 获取一条评论
     */
    Comment getComment(@Param("filmId")Integer filmId, @Param("customerId")String customerId);

}
