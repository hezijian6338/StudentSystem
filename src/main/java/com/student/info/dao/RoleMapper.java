package com.student.info.dao;

import com.student.info.DTO.RolesUserDTO;
import com.student.info.core.Mapper;
import com.student.info.model.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends Mapper<Role> {
    public RolesUserDTO findRoleWithUser(@Param("rolename") String rolename);
    public Role findeRoleByRoleName(@Param("rolename") String rolename);
}