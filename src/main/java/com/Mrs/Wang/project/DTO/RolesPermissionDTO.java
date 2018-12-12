package com.Mrs.Wang.project.DTO;

import com.Mrs.Wang.project.model.Permission;

import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于加载权限列表'角色-权限'关系
 * @author: hezijian6338
 * @create: 2018-12-12 16:17
 **/

public class RolesPermissionDTO {
    private String name;

    private List<Permission> permissions;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
