package com.student.info.service.impl;

import com.student.info.DTO.UserDTO;
import com.student.info.dao.PermissionMapper;
import com.student.info.dao.UserMapper;
import com.student.info.model.Permission;
import com.student.info.model.User;
import com.student.info.service.UserService;
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
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> searchRoleByuser (String username){
        User user = userMapper.findByUserName(username);
        List<Permission> pList = permissionMapper.findByAdminUserId(user.getId());
        List<String> list = new ArrayList<>();
        for (Permission p : pList){
            list.add(p.getName());
        }
        return list;
    }

    @Override
    public User findByUserName(String username){
        return userMapper.findByUserName(username);
    }

    @Override
    public List<UserDTO> findByRoleName(String rolename){
        return userMapper.findByRoleName(rolename);
    }

    @Override
    public List<User> findUserRole() {
        List<User> user = this.findAll();
        List<User> user_rolename = new ArrayList<>();
        for (User user1 : user) {
            User user_role = userMapper.findByUserName(user1.getUsername());
            user_rolename.add(user_role);
        }
        return user_rolename;
    }

}
