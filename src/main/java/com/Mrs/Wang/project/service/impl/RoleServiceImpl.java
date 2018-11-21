package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.RoleMapper;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.service.RoleService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;
}
