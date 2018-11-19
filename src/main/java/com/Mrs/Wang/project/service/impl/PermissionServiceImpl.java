package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.service.PermissionService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper sysPermissionMapper;

}
