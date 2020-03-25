package com.student.info.service.impl;

import com.student.info.DTO.RolesPermissionDTO;
import com.student.info.dao.PermissionMapper;
import com.student.info.model.Permission;
import com.student.info.model.Role;
import com.student.info.service.PermissionService;
import com.student.info.core.AbstractService;
import com.student.info.service.RoleService;
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
