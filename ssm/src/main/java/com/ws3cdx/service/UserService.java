package com.ws3cdx.service;

import com.ws3cdx.model.Cust;
import com.ws3cdx.model.User;

import java.util.List;

public interface UserService {
    User checkUser(User user);

    int delectById(Integer id);

    List<User> showAll();
}
