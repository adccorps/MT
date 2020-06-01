package com.mt.comment.pojo;


import io.swagger.annotations.ApiModel;

@ApiModel
public class CommentDTO {
    public String content;
    public  Integer score;
    public String avatar;
    public String customerName;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "content='" + content + '\'' +
                ", score=" + score +
                ", avatar='" + avatar + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
