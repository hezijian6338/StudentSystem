package com.student.info.dao;

import com.student.info.core.Mapper;
import com.student.info.model.PermissionRole;

public interface PermissionRoleMapper extends Mapper<PermissionRole> {
    public void deleteByRoleid(Long roleid);
}