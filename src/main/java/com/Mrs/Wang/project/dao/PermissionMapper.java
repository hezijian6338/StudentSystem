package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.Permission;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(Long userId);
}