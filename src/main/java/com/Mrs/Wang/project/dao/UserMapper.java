package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.DTO.UserDTO;
import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.User;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public User findByUserName(String username);
    public List<UserDTO> findByRoleName(String rolename);
}