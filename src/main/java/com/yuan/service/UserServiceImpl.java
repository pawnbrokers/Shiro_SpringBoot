package com.yuan.service;

import com.yuan.mapper.UserMapper;
import com.yuan.pojo.Role;
import com.yuan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    final
    UserMapper userMapper;

    //通过构造方法注入
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public List<User> getRoleList(String username) {
        return userMapper.getRoleList(username);
    }
}
