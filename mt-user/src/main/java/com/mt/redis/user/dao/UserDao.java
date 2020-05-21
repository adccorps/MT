package com.mt.redis.user.dao;

import com.mt.redis.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> selectAllUser();
    User selectUserById(@Param("id") String id);
    boolean addUser(@Param("user") User user);

}
