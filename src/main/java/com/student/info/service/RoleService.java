package com.student.info.service;
import com.student.info.DTO.RolesUserDTO;
import com.student.info.model.Role;
import com.student.info.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface RoleService extends Service<Role> {
    public List<RolesUserDTO> findRoleWithUser();

    public List<Role> findRoleWithPermission();
}
