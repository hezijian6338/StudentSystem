package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface PermissionService extends Service<Permission> {
    public List<Permission> findByAdminUserId(Long userId);
}
