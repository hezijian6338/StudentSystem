package com.student.info.service.impl;

import com.student.info.DTO.RolesPermissionDTO;
import com.student.info.dao.PermissionRoleMapper;
import com.student.info.dao.RoleMapper;
import com.student.info.model.Permission;
import com.student.info.model.PermissionRole;
import com.student.info.model.Role;
import com.student.info.service.PermissionRoleService;
import com.student.info.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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
        for (Permission p : rolesPermissionDTO.getPermissions()) {
            PermissionRole permissionRole = new PermissionRole();
            permissionRole.setRoleId(roleMapper.findeRoleByRoleName(role.getName()).getId());
            permissionRole.setPermissionId(p.getId());
            this.save(permissionRole);
        }
    }

}
