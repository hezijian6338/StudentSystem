package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.DTO.UserDTO;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.core.Service;

import javax.validation.OverridesAttribute;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface UserService extends Service<User> {
    List<String> searchRoleByuser(String username);
    public User findByUserName(String username);
    public List<UserDTO> findByRoleName(String rolename);
}
