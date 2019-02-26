package com.ws3cdx.web.controller;

import com.ws3cdx.model.Cust;
import com.ws3cdx.model.User;
import com.ws3cdx.service.CustService;
import com.ws3cdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/cust")
public class CustController {
    @Autowired
    private CustService custService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public String showAll(Model model) {
        List<Cust> custs = custService.showAll();
        List<User> users = userService.showAll();
        model.addAttribute("custs", custs);
        model.addAttribute("users", users);
        return "center";
    }

    @RequestMapping(value = "/add")
    public String add(Cust cust) {
        int i = custService.add(cust);
        return "redirect:/cust/list";
    }

    @RequestMapping(value = "/tomer")
    public String tomer(Model model,
                        @RequestParam(value = "custName") String custName,
                        @RequestParam(value = "custType") String custType) {

        if (custName == null || custName.equals("")) {
            return "redirect:/cust/list";
        }

        List<Cust> custs = custService.tomer(custName, custType);
        List<User> users = userService.showAll();
        model.addAttribute("custs", custs);
        model.addAttribute("users", users);
        model.addAttribute("custName", custName);
        model.addAttribute("custType", custType);

        return "center";
    }
}
