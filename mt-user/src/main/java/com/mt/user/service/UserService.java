package com.mt.user.service;




import com.mt.user.pojo.User;

import java.util.List;



public interface UserService {
    List<User> selectAllUser();
     User selectUserById( String id);
    boolean addUser( User user);
    boolean checkLogin();
}
