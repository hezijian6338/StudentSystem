package com.student.info.dao;

import com.student.info.core.Mapper;
import com.student.info.model.CourseInfoStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoStudentMapper extends Mapper<CourseInfoStudent> {
    public List<CourseInfoStudent> findByStudentno(@Param("studentno") String studentno);
}