package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.PermissionRoleMapper;
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

    public void editPermissionRole(Role role){
        sysPermissionRoleMapper.deleteByRoleid(role.getId());
        for (Permission per : role.getPermissions()) {
            PermissionRole permissionRole = new PermissionRole();
            permissionRole.setPermissionId(per.getId());
            permissionRole.setRoleId(role.getId());
            this.save(permissionRole);
        }
    }

}
