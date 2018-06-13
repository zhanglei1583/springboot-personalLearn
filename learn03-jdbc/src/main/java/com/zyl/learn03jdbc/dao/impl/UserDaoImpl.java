package com.zyl.learn03jdbc.dao.impl;

import com.zyl.learn03jdbc.bean.UserBean;
import com.zyl.learn03jdbc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(UserBean userBean) {
        return jdbcTemplate.update("insert  into user (username,email) values (?,?)", userBean.getUsername(), userBean.getEmail());
    }

    @Override
    public int update(UserBean userBean) {
        return jdbcTemplate.update("update user set  username=? ,email=? where  id=?", userBean.getUsername(), userBean.getEmail(), userBean.getId());
    }

    @Override
    public int delete(UserBean userBean) {
        return jdbcTemplate.update("delete  from  user where id=?", userBean.getId());
    }

    @Override
    public UserBean findUserById(int id) {
        List<UserBean> list = jdbcTemplate.query("select * from user where id=?", new Object[]{id}, new BeanPropertyRowMapper(UserBean.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<UserBean> findUserList() {
        List<UserBean> list = jdbcTemplate.query("select * from user ", new Object[]{}, new BeanPropertyRowMapper(UserBean.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
