package com.ws3cdx.web.controller;

import com.alibaba.druid.mock.MockArray;
import com.ws3cdx.model.User;
import com.ws3cdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check")
    public String checkUser(Model model, User user) {
        System.out.println(user);
        User checkUser = userService.checkUser(user);
        if (checkUser != null) {
            model.addAttribute("user", user);
            return "index";
        }
        return "failer";
    }

    @RequestMapping(value = "/deleteById/{id}")
    public String delectById(@PathVariable(value = "id") Integer id) {
        int i = userService.delectById(id);
        return "redirect:/cust/list";
    }

}
