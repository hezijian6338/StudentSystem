package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.DTO.RolesPermissionDTO;
import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.service.PermissionService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper sysPermissionMapper;
    @Resource
    private RoleService roleService;

    @Override
    public List<Permission> findByAdminUserId(Long userId){
        return sysPermissionMapper.findByAdminUserId(userId);
    }

    @Override
    public List<RolesPermissionDTO> findRoleWithPermission() {
        List<RolesPermissionDTO> rolesPermission = new ArrayList<>();
        List<Role> roles = roleService.findAll();
        for(Role role : roles){
            RolesPermissionDTO rp = sysPermissionMapper.findRoleWithPermission(role.getName());
            rolesPermission.add(rp);
        }
        return rolesPermission;
    }

}
