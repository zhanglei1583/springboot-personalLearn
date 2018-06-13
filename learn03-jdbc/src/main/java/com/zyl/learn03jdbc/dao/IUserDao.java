package com.zyl.learn03jdbc.dao;

import com.zyl.learn03jdbc.bean.UserBean;

import java.util.List;

public interface IUserDao {
    int add(UserBean userBean);

    int update(UserBean userBean);

    int delete(UserBean userBean);

    UserBean findUserById(int id);

    List<UserBean> findUserList();

}
