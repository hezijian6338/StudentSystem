package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.DTO.CourseInfoStuCondition;
import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.CourseInfo;

import java.util.List;

public interface CourseInfoMapper extends Mapper<CourseInfo> {
    /**
     * TODO: 根据DTO的条件来筛选该学生可选的课程
     * @author hezijian6338
     * @date 2019/3/13 15:00
     * @param courseInfoStuCondition
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/

    public List<CourseInfo> searchByCondition(CourseInfoStuCondition courseInfoStuCondition);

    /**
     * TODO: 忘记了...
     * @author hezijian6338
     * @date 2019/3/13 15:01
     * @param
     * @return java.util.List<java.lang.String>
     * @throws
     **/

    public List<String> conditionOfAca();

    /**
     * TODO: 根据课程代码获取课程信息
     * @author hezijian6338
     * @date 2019/3/13 15:00
     * @param courseCode
     * @return com.Mrs.Wang.project.model.CourseInfo
     * @throws
     **/

    public CourseInfo findByCourseCode(String courseCode);
}