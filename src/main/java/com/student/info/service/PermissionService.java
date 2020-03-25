package com.student.info.service;
import com.student.info.DTO.RolesPermissionDTO;
import com.student.info.model.Permission;
import com.student.info.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface PermissionService extends Service<Permission> {
    public List<Permission> findByAdminUserId(Long userId);
    public List<RolesPermissionDTO> findRoleWithPermission();
}
