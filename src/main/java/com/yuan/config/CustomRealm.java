package com.yuan.config;

import com.yuan.pojo.Permission;
import com.yuan.pojo.Role;
import com.yuan.pojo.User;
import com.yuan.service.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


public class CustomRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    private UserServiceImpl userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("=================开始授权==================");
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.getUserByName(username);
        if (user == null) return null;

        //开始授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<User> roleList = userService.getRoleList(username);
        for (User user1 : roleList) {
            List<String> roleList1 = new ArrayList<>();
            for (Role role : user1.getRoleList()) {
                roleList1.add(role.getRole_name());
            }
            System.out.println(roleList1.toString());
            info.addRoles(roleList1);
        }
        logger.info("=================结束授权==================");
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("--------开始认证当前用户的信息");

        String username = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByName(username);
        if (user == null) return null;

        //参数1，principal,认证的主体可以是username
        Object principal = username;
        //参数2 password 获取当前用户的密码

        String password = user.getPassword();
        System.out.println(password);

        //参数3，盐值，如果进行了密码加密，这个参数就需要
//        ByteSource salt = ByteSource.Util.bytes("mengxin");
//
        //参数4： realmName ，当前realm的唯一名字
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, password, null, realmName);
        return info;

    }
}
