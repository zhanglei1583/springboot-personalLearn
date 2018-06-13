package com.zyl.learn03jdbc.service.impl;

import com.zyl.learn03jdbc.bean.UserBean;
import com.zyl.learn03jdbc.dao.IUserDao;
import com.zyl.learn03jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao;
    @Override
    public int add(UserBean userBean) {
        return iUserDao.add(userBean);
    }

    @Override
    public int update(UserBean userBean) {
        return iUserDao.update(userBean);
    }

    @Override
    public int delete(UserBean userBean) {
        return iUserDao.delete(userBean);
    }

    @Override
    public UserBean findUserById(int id) {
        return iUserDao.findUserById(id);
    }

    @Override
    public List<UserBean> findUserList() {
        return iUserDao.findUserList();
    }
}
