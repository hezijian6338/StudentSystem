package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.CourseInfoMapper;
import com.Mrs.Wang.project.dao.CourseInfoStudentMapper;
import com.Mrs.Wang.project.dao.StudentsMapper;
import com.Mrs.Wang.project.dao.TeacherInfoMapper;
import com.Mrs.Wang.project.model.*;
import com.Mrs.Wang.project.service.CourseInfoService;
import com.Mrs.Wang.project.service.CourseInfoStudentService;
import com.Mrs.Wang.project.service.LearningguidStudentslistService;
import com.Mrs.Wang.project.service.StudentsService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.utils.UUIDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 *
 * @author hezijian6338
 */
@Service
@Transactional
public class StudentsServiceImpl extends AbstractService<Students> implements StudentsService {

    @Resource
    private StudentsMapper tStudentsMapper;

    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Resource
    private CourseInfoService courseInfoService;

    @Resource
    private TeacherInfoMapper teacherInfoMapper;

    @Resource
    private LearningguidStudentslistService learningguidStudentslistService;

    @Resource
    private CourseInfoStudentService courseInfoStudentService;

    /**
     * TODO: 可选课程
     *
     * @param students
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     * @author hezijian6338
     * @date 2019/3/13 13:48
     **/

    @Override
    public List<CourseInfo> findCourseWithStudent(Students students) {
        return tStudentsMapper.findCourseWithStudent(students);
    }

    /**
     * TODO: 根据学生学号来找学生信息
     *
     * @param studentno
     * @return com.Mrs.Wang.project.model.Students
     * @throws
     * @author hezijian6338
     * @date 2019/3/13 15:28
     **/

    @Override
    public Students findByStudentno(String studentno) {
        return tStudentsMapper.findByStudentno(studentno);
    }


    /**
     * TODO: 保存选课信息的实例
     *
     * @param studentno
     * @param courses
     * @return void
     * @throws
     * @author hezijian6338
     * @date 2019/3/13 14:44
     **/

    @Override
    public void saveSelectedCourses(String studentno, List<String> courses) {
        Students student = tStudentsMapper.findByStudentno(studentno);
        for (String courseCode : courses) {
            CourseInfo courseInfo = courseInfoService.findBy("id", courseCode);
            if (isObjectNotEmpty(courseInfo)) {
                CourseInfoStudent courseInfoStudent = new CourseInfoStudent();
                courseInfoStudent.setId(UUIDUtils.getUUID());
                courseInfoStudent.setStuname(student.getStuname());
                courseInfoStudent.setStudentno(student.getStudentno());
                courseInfoStudent.setOrgName(student.getOrgName());
                courseInfoStudent.setOrgId(student.getOrgId());
                courseInfoStudent.setStuId(student.getStuId());
                courseInfoStudent.setGrade(student.getGrade());
                courseInfoStudent.setMajor(student.getMajor());
                courseInfoStudent.setMajorcode(student.getMajorCode());
                courseInfoStudent.setClassname(student.getClassname());
                courseInfoStudent.setCreator(student.getStuId());
                courseInfoStudent.setCoursename(courseInfo.getCoursename());
                courseInfoStudent.setCoursecode(courseInfo.getCoursecode());
                courseInfoStudent.setCoursetype(courseInfo.getCoursetype());
                courseInfoStudent.setCredit(courseInfo.getCredit());
                courseInfoStudent.setEmployNo(courseInfo.getEmployNo());
                courseInfoStudent.setEmployName(courseInfo.getEmployName());
                courseInfoStudent.setAcademicyear(courseInfo.getAcademicyear());
                courseInfoStudent.setTerm(courseInfo.getTerm());
                courseInfoStudent.setCreateTime(new Date());
                courseInfoStudentService.save(courseInfoStudent);
            }
        }
    }

    @Override
    public List<CourseInfoStudent> findSelectedCoursesByStudentno(String studentno) {
        return tStudentsMapper.findSelectedCoursesByStudentno(studentno);
    }

    @Override
    public void saveSelectGuidTeacher(String studentno, String teacherno) {
        Students student = tStudentsMapper.findByStudentno(studentno);
        TeacherInfo teacher = teacherInfoMapper.findByTeacherno(teacherno);
        LearningguidStudentslist ls = new LearningguidStudentslist();
        ls.setId(UUIDUtils.getUUID());
        ls.setTeacherno(teacher.getEmployNo());
        ls.setTeachername(teacher.getEmployName());
        ls.setStuname(student.getStuname());
        ls.setStuId(student.getStuId());
        ls.setClassname(student.getClassname());
        ls.setCreateTime(new Date());
        // 未完成setter,数据不完整
    }

    @Override
    public TeacherInfo findSelectedGuidTeacherByStudentno(String studentno) {
        LearningguidStudentslist ls = learningguidStudentslistService.findBy("studentno", studentno);
        TeacherInfo teacherInfo = teacherInfoMapper.findByTeacherno(ls.getTeacherno());
        return teacherInfo;
    }

    @Override
    public List<Students> findStudentsByUser(List<User> users) {
        List<Students> students = new ArrayList<>();
        for (User user : users) {
            Students student = tStudentsMapper.findByStudentno(user.getUsername());
            if (isObjectNotEmpty(student)) {
                students.add(student);
            }
        }
        return students;
    }

    /**
     *      * 判断Object对象为空或空字符串
     *      * @param obj
     *      * @return
     *     
     */


    public Boolean isObjectNotEmpty(Object obj) {
        String str = ObjectUtils.toString(obj, "");
        return StringUtils.isNotBlank(str);
    }


}
