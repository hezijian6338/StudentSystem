package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.PermissionRole;
import com.Mrs.Wang.project.core.Service;
import com.Mrs.Wang.project.model.Role;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface PermissionRoleService extends Service<PermissionRole> {
    public void editPermissionRole(Role role);
}
