package com.student.info.dao;

import com.student.info.DTO.CourseInfoStuCondition;
import com.student.info.core.Mapper;
import com.student.info.model.CourseInfo;

import java.util.List;

public interface CourseInfoMapper extends Mapper<CourseInfo> {
    /**
     * TODO: 根据DTO的条件来筛选该学生可选的课程
     * @author hezijian6338
     * @date 2019/3/13 15:00
     * @param courseInfoStuCondition
     * @return java.util.List<CourseInfo>
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
     * @return CourseInfo
     * @throws
     **/

    public CourseInfo findByCourseCode(String courseCode);

    /**
     * TODO: 根据老师代码获取课程信息
     * @author hezijian6338
     * @date 2019/3/13 15:00
     * @param teacherNo
     * @return CourseInfo
     * @throws
     **/
    List<CourseInfo> findSelectedCoursesByTeacherNo(String teacherNo);
}