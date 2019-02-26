package com.ws3cdx.service.impl;

import com.ws3cdx.dao.UserDao;
import com.ws3cdx.model.Cust;
import com.ws3cdx.model.User;
import com.ws3cdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User checkUser(User user) {
        System.out.println(user.getUsername());
        User checkUser = userDao.checkUser(user.getUsername(), user.getPassword());
        System.out.println(user.getPassword());
        return checkUser;
    }

    @Override
    public int delectById(Integer id) {
        return userDao.delectById(id);
    }

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }
}
