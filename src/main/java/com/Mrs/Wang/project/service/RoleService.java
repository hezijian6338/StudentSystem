package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.DTO.RolesUserDTO;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface RoleService extends Service<Role> {
    public List<RolesUserDTO> findRoleWithUser();

    public List<Role> findRoleWithPermission();
}
