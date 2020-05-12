package com.yuan.mapper;


import com.yuan.pojo.Role;
import com.yuan.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    @Select("select * from user1 where username = #{username}")
    User getUserByName(@Param("username") String username);


    List<User> getRoleList(String username);


}
