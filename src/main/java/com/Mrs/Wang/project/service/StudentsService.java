package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.core.Service;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 * @author hezijian6338
 */
public interface StudentsService extends Service<Students> {
    /**
     * TODO: 接口~
     * @author hezijian6338
     * @date 2019/3/13 14:33
     * @param students
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/
    public List<CourseInfo> findCourseWithStudent(Students students);

    /**
     * TODO: 根据用户返回的学生信息和选课课程代码编号来进行选课录入
     * @author hezijian6338
     * @date 2019/3/13 14:36
     * @param studentno
     * @param courses
     * @return void
     * @throws
     **/

    public void saveSelectedCourses(String studentno, List<String> courses);

    /**
     * TODO: 根据学生学号查找学生信息
     * @author hezijian6338
     * @date 2019/3/13 15:49
     * @param studentno
     * @return com.Mrs.Wang.project.model.Students
     * @throws
     **/

    public Students findByStudentno(String studentno);

    /**
     * TODO: 根据学生学号查找已选课程
     * @author hezijian6338
     * @date 2019/3/13 15:50
     * @param studentno
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/

    public List<CourseInfo> findSelectedCoursesByStudentno(String studentno);

}
