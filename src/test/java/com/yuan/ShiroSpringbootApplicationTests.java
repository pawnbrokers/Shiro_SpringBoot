package com.yuan;

import com.yuan.pojo.Permission;
import com.yuan.pojo.Role;
import com.yuan.pojo.User;
import com.yuan.service.RoleService;
import com.yuan.service.RoleServiceImpl;
import com.yuan.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Test
    void contextLoads() {




        List<User> dalao = userService.getRoleList("dalao");
        for (User user : dalao) {
            System.out.println(user);
        }


    }


    @Test
    public void testRole(){
        List<Role> roleListByUserId = roleService.getRoleListByUserId(2);
        for (Role role : roleListByUserId) {
            System.out.println(role);
        }
    }

}
