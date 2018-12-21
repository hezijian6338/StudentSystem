package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.PermissionRole;

public interface PermissionRoleMapper extends Mapper<PermissionRole> {
    public void deleteByRoleid(Long roleid);
}