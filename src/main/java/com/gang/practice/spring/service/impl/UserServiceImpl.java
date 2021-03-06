package com.gang.practice.spring.service.impl;

import com.gang.practice.spring.dao.UserDao;
import com.gang.practice.spring.po.User;
import com.gang.practice.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author GaoGang
 * @Date 2016-08-22 15:54
 * @Version V1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService<User> {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    @Override
    public boolean addUser(User entity) {
        boolean flag = false;
        try {
            userDao.addUser(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean editUser(User entity) {
        boolean flag = false;
        try {
            userDao.editUser(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(Integer id) {
        boolean flag = false;
        try {
            userDao.deleteUser(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String checkUser(User user) {
        String userId="";
        try {
            User u = userDao.checkUser(user);
            if (u != null) {
                userId=String.valueOf(u.getUserId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public User getUserInfo(Integer id) {
        return userDao.getUserInfo(id);
    }


    @Override
    public List<User> getUser(Map<String, Object> condition) {
        return userDao.getUser(condition);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}
