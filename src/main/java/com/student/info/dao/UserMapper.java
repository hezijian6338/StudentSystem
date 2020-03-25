package com.student.info.dao;

import com.student.info.DTO.UserDTO;
import com.student.info.core.Mapper;
import com.student.info.model.User;
import java.util.List;

public interface UserMapper extends Mapper<User> {
    public User findByUserName(String username);
    public List<UserDTO> findByRoleName(String rolename);
    public List<String> findUserNonPw();
}