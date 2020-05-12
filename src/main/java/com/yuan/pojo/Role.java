package com.yuan.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private int id;
    private String role_name;
    private User user;
    private List<Permission> permissionList;

}
