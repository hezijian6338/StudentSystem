package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.User;

public interface UserMapper extends Mapper<User> {
    public User findByUserName(String username);
}