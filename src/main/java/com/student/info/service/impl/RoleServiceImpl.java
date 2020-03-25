package com.student.info.service.impl;

import com.student.info.DTO.RolesUserDTO;
import com.student.info.dao.RoleMapper;
import com.student.info.model.Role;
import com.student.info.service.RoleService;
import com.student.info.core.AbstractService;
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

    @Override
    public List<RolesUserDTO> findRoleWithUser() {
        List<Role> roles = this.findAll();
        List<RolesUserDTO> rolesUserList = new ArrayList<>();
        for (Role role : roles) {
            RolesUserDTO rolesUser = roleMapper.findRoleWithUser(role.getName());
            rolesUserList.add(rolesUser);
        }
        return rolesUserList;
    }

    @Override
    public List<Role> findRoleWithPermission() {
        List<Role> roles = this.findAll();
        List<Role> role_per = new ArrayList<>();
        for(Role role : roles) {
            role_per.add(roleMapper.findeRoleByRoleName(role.getName()));
        }
        return role_per;
    }
}
