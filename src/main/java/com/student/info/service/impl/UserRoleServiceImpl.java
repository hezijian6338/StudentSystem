package com.student.info.service.impl;

import com.student.info.dao.UserRoleMapper;
import com.student.info.model.Role;
import com.student.info.model.User;
import com.student.info.model.UserRole;
import com.student.info.service.UserRoleService;
import com.student.info.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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
