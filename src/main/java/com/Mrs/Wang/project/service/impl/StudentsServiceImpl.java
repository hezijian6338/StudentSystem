package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.CourseInfoMapper;
import com.Mrs.Wang.project.dao.StudentsMapper;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.service.StudentsService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 * @author hezijian6338
 */
@Service
@Transactional
public class StudentsServiceImpl extends AbstractService<Students> implements StudentsService {

    @Resource
    private StudentsMapper tStudentsMapper;

    @Resource
    private CourseInfoMapper courseInfoMapper;

    /**
     * TODO: 方法描述
     * @author hezijian6338
     * @date 2019/3/13 13:48
     * @param students
     * @return java.util.List<com.Mrs.Wang.project.model.CourseInfo>
     * @throws
     **/

    @Override
    public List<CourseInfo> findCourseWithStudent(Students students) {
        return tStudentsMapper.findCourseWithStudent(students);
    }

    /**
     * TODO: 根据学生学号来找学生信息
     * @author hezijian6338
     * @date 2019/3/13 15:28
     * @param studentno
     * @return com.Mrs.Wang.project.model.Students
     * @throws
     **/

    @Override
    public Students findByStudentno(String studentno) {
        return tStudentsMapper.findByStudentno(studentno);
    }


    /**
     * TODO: 保存选课信息的实例
     * @author hezijian6338
     * @date 2019/3/13 14:44
     * @param studentno
     * @param courses
     * @return void
     * @throws
     **/

    @Override
    public void saveSelectedCourses(String studentno, List<String> courses) {
        Students student = tStudentsMapper.findByStudentno(studentno);
        for (String courseCode : courses) {
            CourseInfo courseInfo = courseInfoMapper.findByCourseCode(courseCode);
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
        }
    }

    @Override
    public List<CourseInfo> findSelectedCoursesByStudentno(String studentno) {
        return tStudentsMapper.findSelectedCoursesByStudentno(studentno);
    }

}
