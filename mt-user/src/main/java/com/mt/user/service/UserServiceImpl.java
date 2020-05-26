package com.mt.user.service;


import com.mt.user.dao.UserDao;
import com.mt.user.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
   private UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public User selectUserById(String id) {
        return userDao.selectUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean checkLogin() {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }


}
