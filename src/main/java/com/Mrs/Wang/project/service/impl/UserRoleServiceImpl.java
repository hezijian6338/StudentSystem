package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.UserRoleMapper;
import com.Mrs.Wang.project.model.UserRole;
import com.Mrs.Wang.project.service.UserRoleService;
import com.Mrs.Wang.project.core.AbstractService;
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

}
