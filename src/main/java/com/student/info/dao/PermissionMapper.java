package com.student.info.dao;

import com.student.info.DTO.RolesPermissionDTO;
import com.student.info.core.Mapper;
import com.student.info.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(Long userId);
    public RolesPermissionDTO findRoleWithPermission(@Param("rolename") String rolename);
}