package com.student.info.service;
import com.student.info.DTO.RolesPermissionDTO;
import com.student.info.model.PermissionRole;
import com.student.info.core.Service;
import com.student.info.model.Role;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface PermissionRoleService extends Service<PermissionRole> {

    /**
     * TODO: 编辑角色权限关系
     * @author hezijian6338
     * @date 2019/3/21 15:17
     * @param role
     * @return void
     * @throws
     **/

    public void editPermissionRole(Role role);

    /**
     * TODO: 新增新的角色并且关联权限
     * @author hezijian6338
     * @date 2019/3/21 15:18
     * @param rolesPermissionDTO
     * @return void
     * @throws
     **/

    public void addPermissionRole(RolesPermissionDTO rolesPermissionDTO);
}
