package com.student.info.service;
import com.student.info.DTO.UserDTO;
import com.student.info.model.User;
import com.student.info.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface UserService extends Service<User> {
    List<String> searchRoleByuser(String username);
    public User findByUserName(String username);
    public List<UserDTO> findByRoleName(String rolename);
    public List<User> findUserRole();
}
