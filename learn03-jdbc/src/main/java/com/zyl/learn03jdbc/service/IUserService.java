package com.zyl.learn03jdbc.service;

import com.zyl.learn03jdbc.bean.UserBean;

import java.util.List;

public interface IUserService {
    int add(UserBean userBean);

    int update(UserBean userBean);

    int delete(UserBean userBean);

    UserBean findUserById(int id);

    List<UserBean> findUserList();
}
