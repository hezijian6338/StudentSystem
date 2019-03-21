package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.DTO.RolesPermissionDTO;
import com.Mrs.Wang.project.dao.PermissionRoleMapper;
import com.Mrs.Wang.project.dao.RoleMapper;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.model.PermissionRole;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.service.PermissionRoleService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class PermissionRoleServiceImpl extends AbstractService<PermissionRole> implements PermissionRoleService {
    @Resource
    private PermissionRoleMapper sysPermissionRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public void editPermissionRole(Role role){
        sysPermissionRoleMapper.deleteByRoleid(role.getId());
        for (Permission per : role.getPermissions()) {
            PermissionRole permissionRole = new PermissionRole();
            permissionRole.setPermissionId(per.getId());
            permissionRole.setRoleId(role.getId());
            this.save(permissionRole);
        }
    }

    @Override
    public void addPermissionRole(RolesPermissionDTO rolesPermissionDTO) {
        Role role = new Role();
        role.setName(rolesPermissionDTO.getName());
        roleMapper.insert(role);
        PermissionRole permissionRole = new PermissionRole();
        permissionRole.setRoleId(roleMapper.findeRoleByRoleName(role.getName()).getId());
        for (Permission p : rolesPermissionDTO.getPermissions()) {
            permissionRole.setPermissionId(p.getId());
            this.save(permissionRole);
        }
    }

}
