package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.DTO.RolesUserDTO;
import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {
    public List<Map<String,Object>> findRoleWithUser();
}