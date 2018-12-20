package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.DTO.RolesUserDTO;
import com.Mrs.Wang.project.dao.RoleMapper;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.service.RoleService;
import com.Mrs.Wang.project.core.AbstractService;
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
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    public List<RolesUserDTO> findRoleWithUser() {
        List<Role> roles = this.findAll();
        List<RolesUserDTO> rolesUserList = new ArrayList<>();
        for (Role role : roles) {
            RolesUserDTO rolesUser = roleMapper.findRoleWithUser(role.getName());
            rolesUserList.add(rolesUser);
        }
        return rolesUserList;
    }

    public List<Role> findRoleWithPermission() {
        List<Role> roles = this.findAll();
        List<Role> role_per = new ArrayList<>();
        for(Role role : roles) {
            role_per.add(roleMapper.findeRoleByRoleName(role.getName()));
        }
        return role_per;
    }
}
