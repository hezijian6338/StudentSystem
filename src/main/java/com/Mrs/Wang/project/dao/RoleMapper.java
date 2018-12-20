package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.DTO.RolesUserDTO;
import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {
    public RolesUserDTO findRoleWithUser(@Param("rolename") String rolename);
    public Role findeRoleByRoleName(@Param("rolename") String rolename);
}