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
    @Resource
    private UserService userService;

    public void editUserRole(User user) {
        User old_user = userService.findByUserName(user.getUsername());
        userRoleMapper.deleteByUserid(user.getId());
        for (Role new_role : user.getRoles()) {
            for (Role old_role : old_user.getRoles()) {
                UserRole userRole = new UserRole();
                userRole.setSysRoleId(new_role.getId());
                userRole.setSysUserId(user.getId());
                this.save(userRole);
            }
        }
    }

}
