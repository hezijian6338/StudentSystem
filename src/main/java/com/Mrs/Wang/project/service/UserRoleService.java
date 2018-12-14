package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.model.UserRole;
import com.Mrs.Wang.project.core.Service;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface UserRoleService extends Service<UserRole> {
    public void editUserRole(User user);

}
