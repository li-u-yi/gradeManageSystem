package com.ly.service;

import com.ly.Dao.UserDao;
import com.ly.entity.User;

public class UserService {
    /**
     * 登录校验
     * @param userid 账号
     * @param password 密码
     * @return 是否登录成功
     */
    public User loginCheck(String userid, String password,String role) {
        UserDao userDao = new UserDao();

        User userRes = userDao.getUserByUserIdAndPasswordAndRole(userid, password,role);

        return userRes;
    }

    public void insertUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
