package com.yuan.service;

import com.yuan.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleListByUserId(int role_id);
}
