package com.mt.api;

import com.mt.pojo.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-comment")
public interface CommentApi {
    @GetMapping("/comment/{filmId}")
    Object listComment(@PathVariable("filmId") int filmId);

    /**
     * 新增评论
     */
    @PostMapping("/comment")
    Object insertComment(@RequestBody Comment comment);

    /**
     * 查询是否可以评论
     */
    @GetMapping("/film/comment")
    boolean isComment(Integer filmId, String customerId);
}