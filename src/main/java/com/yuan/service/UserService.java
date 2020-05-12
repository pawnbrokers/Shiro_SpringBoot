package com.yuan.service;

import com.yuan.pojo.Role;
import com.yuan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User getUserByName(@Param("username") String username);

    List<User> getRoleList(String username);

}
