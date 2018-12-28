package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.DTO.CourseInfoStuCondition;
import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.CourseInfo;

import java.util.List;

public interface CourseInfoMapper extends Mapper<CourseInfo> {
    public List<CourseInfo> searchByCondition(CourseInfoStuCondition courseInfoStuCondition);
    public List<String> conditionOfAca();
}