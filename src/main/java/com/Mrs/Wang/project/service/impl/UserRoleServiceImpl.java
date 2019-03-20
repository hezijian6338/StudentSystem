package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.UserRoleMapper;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.model.UserRole;
import com.Mrs.Wang.project.service.UserRoleService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.service.UserService;
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
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public void editUserRole(User user) {
        userRoleMapper.deleteByUserid(user.getId());
        for (Role role : user.getRoles()) {
            UserRole userRole = new UserRole();
            userRole.setSysRoleId(role.getId());
            userRole.setSysUserId(user.getId());
            this.save(userRole);
        }
    }

}
