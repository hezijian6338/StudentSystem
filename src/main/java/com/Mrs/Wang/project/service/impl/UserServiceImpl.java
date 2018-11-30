package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.service.UserService;
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
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PermissionMapper permissionMapper;

    public List<String> searchRoleByuser (String username){
        User user = userMapper.findByUserName(username);
        List<Permission> pList = permissionMapper.findByAdminUserId(user.getId());
        List<String> list = new ArrayList<>();
        for (Permission p : pList){
            list.add(p.getName());
        }
        return list;
    }

}
