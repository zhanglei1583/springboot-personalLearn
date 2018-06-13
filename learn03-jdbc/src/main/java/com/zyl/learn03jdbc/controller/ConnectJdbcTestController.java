package com.zyl.learn03jdbc.controller;

import com.zyl.learn03jdbc.bean.UserBean;
import com.zyl.learn03jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectJdbcTestController {
    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserBean> getUsers() {
        return iUserService.findUserList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserBean getUserById(@PathVariable("id") int id) {
        return iUserService.findUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") int id, @RequestParam(value = "username", required = true) String username,
                             @RequestParam(value = "email", required = true) String email) {
        UserBean userBean = new UserBean();
        userBean.setEmail(email);
        userBean.setId(id);
        userBean.setUsername(username);
        int t = iUserService.update(userBean);
        if (t == 1) {
            return userBean.toString();
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestParam(value = "username") String username,
                           @RequestParam(value = "email") String email) {
        UserBean userBean = new UserBean();
        userBean.setEmail(email);
        userBean.setUsername(username);
        int t = iUserService.add(userBean);
        if (t == 1) {
            return userBean.toString();
        } else {
            return "fail";
        }

    }
}
