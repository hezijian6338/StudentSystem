package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.service.UserService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
