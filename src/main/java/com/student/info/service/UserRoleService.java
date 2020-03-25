package com.student.info.service;
import com.student.info.model.User;
import com.student.info.model.UserRole;
import com.student.info.core.Service;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface UserRoleService extends Service<UserRole> {
    public void editUserRole(User user);

}
