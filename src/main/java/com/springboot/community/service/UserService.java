package com.springboot.community.service;

import com.springboot.community.dao.UserDao;
import com.springboot.community.dao.UserDaoImpl;
import com.springboot.community.model.User;

/**
 * ClassName:UserService
 * Package:com.springboot.community.service
 * Descripetion:
 *
 * @Date:2019/12/30 21:24
 * @Author: 李一鹏
 */
public class UserService {
    public static Boolean insert(User user){
        UserDao usrDao = new UserDaoImpl();
        Boolean insert = usrDao.insert(user.getName(), user.getAccountId(), user.getToken(), user.getGmtCreate(), user.getGetModified());
        if (insert) {
            return true;
        }
        return false;
    }
}
