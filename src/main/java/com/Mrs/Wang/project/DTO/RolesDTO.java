package com.Mrs.Wang.project.DTO;

import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于简单输出用户的访问权限列表
 * @author: hezijian6338
 * @create: 2018-11-30 14:39
 **/

public class RolesDTO {
    List<String> roles;

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }
}
