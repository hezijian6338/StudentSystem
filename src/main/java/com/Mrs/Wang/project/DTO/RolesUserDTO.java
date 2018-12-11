package com.Mrs.Wang.project.DTO;

import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于加载权限列表中的'角色-用户'关系
 * @author: hezijian6338
 * @create: 2018-12-11 15:15
 **/

public class RolesUserDTO {
    private String rolename;

    private List<UserDTO> username;

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<UserDTO> getUsername() {
        return username;
    }

    public void setUsername(List<UserDTO> username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }
}
