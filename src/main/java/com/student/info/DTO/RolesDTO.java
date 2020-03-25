package com.student.info.DTO;

import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于简单输出用户的访问权限列表
 * @author: hezijian6338
 * @create: 2018-11-30 14:39
 **/

public class RolesDTO {
    private List<String> roles;

    private String avatar;

    private String name;

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
