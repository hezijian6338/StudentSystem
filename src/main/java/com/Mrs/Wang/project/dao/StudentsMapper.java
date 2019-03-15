package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.Students;

import java.util.List;

public interface StudentsMapper extends Mapper<Students> {

    /**
     * TODO:
     * @author hezijian6338
     * @date 2019/3/13 13:47
     * @param students
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/

    public List<CourseInfo> findCourseWithStudent(Students students);

    /**
     * TODO: 根据学生的学号查找学生信息
     * @author hezijian6338
     * @date 2019/3/13 14:50
     * @param studentno
     * @return com.Mrs.Wang.project.model.Students
     * @throws
     **/

    public Students findByStudentno(String studentno);

    /**
     * TODO: 根据学生的学号来查找他已选的课程
     * @author hezijian6338
     * @date 2019/3/13 15:48
     * @param studentno
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/

    public List<CourseInfo> findSelectedCoursesByStudentno(String studentno);

}