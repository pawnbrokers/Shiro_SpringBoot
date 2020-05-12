package com.yuan.controller;


import com.yuan.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {





    @RequestMapping(value = "/subLogin", method = RequestMethod.POST)
    public String subLogin(String username,String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "403";
        }

        if (subject.hasRole("admin")) {
            System.out.println("有admin权限");
        } else {
            System.out.println("无admin权限");
        }

        return "success";


    }



}
