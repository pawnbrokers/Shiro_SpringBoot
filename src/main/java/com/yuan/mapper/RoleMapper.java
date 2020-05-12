package com.yuan.mapper;


import com.yuan.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    @Select("select * from role where user_id = #{role_id}")
    List<Role> getRoleListByUserId(int role_id);
}
