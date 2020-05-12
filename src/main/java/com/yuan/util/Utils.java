package com.yuan.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Utils {

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123","mengxin",1);
        System.out.println(md5Hash.toString());
    }
}
