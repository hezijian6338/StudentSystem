package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoStudentMapper extends Mapper<CourseInfoStudent> {
    public List<CourseInfoStudent> findByStudentno(@Param("studentno") String studentno);
    public List<String> conditionOfAca();
}