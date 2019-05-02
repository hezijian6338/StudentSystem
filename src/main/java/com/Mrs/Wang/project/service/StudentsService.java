package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.*;
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
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfoStudent>
     * @throws
     **/

    public List<CourseInfoStudent> findSelectedCoursesByStudentno(String studentno);

    /**
     * TODO: 学生选择导学老师
     * @author hezijian6338
     * @date 2019/3/14 9:25
     * @param studentno
     * @param teacherno
     * @return void
     * @throws
     **/

    public void saveSelectGuidTeacher(String studentno, String teacherno);

    /**
     * TODO: 根据学号查询已经选择的导学老师
     * @author hezijian6338
     * @date 2019/3/14 9:58
     * @param studentno
     * @return com.Mrs.Wang.project.model.TeacherInfo
     * @throws
     **/

    public TeacherInfo findSelectedGuidTeacherByStudentno(String studentno);

    /***
     * TODO: 根据已经添加的用户查找学生的信息
     * @author hezijian6338
     * @date 2019/5/2
     * @param users
     * @return java.util.List<com.Mrs.Wang.project.model.Students>
     */

    public List<Students> findStudentsByUser(List<User> users);

}
