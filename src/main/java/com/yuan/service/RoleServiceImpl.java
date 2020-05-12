package com.yuan.service;

import com.yuan.mapper.RoleMapper;
import com.yuan.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRoleListByUserId(int user_id) {
        return roleMapper.getRoleListByUserId(user_id);
    }
}
