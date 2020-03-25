package com.student.info.dao;

import com.student.info.core.Mapper;
import com.student.info.model.UserRole;

public interface UserRoleMapper extends Mapper<UserRole> {
    public void deleteByUserid(Long userid);
}