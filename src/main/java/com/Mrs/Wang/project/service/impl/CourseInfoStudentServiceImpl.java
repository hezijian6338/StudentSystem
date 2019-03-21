package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.CourseInfoStudentMapper;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.service.CourseInfoStudentService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class CourseInfoStudentServiceImpl extends AbstractService<CourseInfoStudent> implements CourseInfoStudentService {
    @Resource
    private CourseInfoStudentMapper tCourseinfoStudentsMapper;

    public void addCourses(Students students, CourseInfo courseInfo) {
        CourseInfoStudent cis = new CourseInfoStudent();
        //创建人，时间，学分，实验室等等字段没填写，待定
        cis.setId(UUIDUtils.getUUID());
        cis.setAcademicyear(courseInfo.getAcademicyear());
        cis.setClassname(courseInfo.getCoursename());
        cis.setCoursecode(courseInfo.getCoursecode());
        cis.setCoursetype(courseInfo.getCoursetype());
        cis.setEmployName(courseInfo.getEmployName());
        cis.setEmployNo(courseInfo.getEmployNo());
        cis.setGrade(students.getGrade());
        cis.setStuId(students.getStuId());
        cis.setStudentno(students.getStudentno());
        cis.setStuname(students.getStuname());
        cis.setOrgId(students.getOrgId());
        cis.setOrgName(students.getOrgName());
        cis.setTerm(courseInfo.getTerm());
        cis.setTotalhours(courseInfo.getTotalhours());
        cis.setMajor(students.getMajor());
        cis.setCredit(courseInfo.getCredit());
        cis.setMajorcode(students.getMajorCode());
    }

    @Override
    public void studentToCourseCodes(String studentno, List<String> courseids) {
        List<String> list = this.findIdsByStudentno(studentno);
        for (String exist : list) {
            if (!courseids.contains(exist)) {
                System.out.println("应该被删除的课程名称:" + this.findBy("id", exist).getCoursename());
            }
        }
        for (String add : courseids) {
            if (!list.contains(add)) {
                System.out.println("应该添加的课程名称:" + this.findBy("id", add).getCoursename());
            }
        }

    }

    @Override
    public List<CourseInfoStudent> findByStudentno(String studentno) {
        return tCourseinfoStudentsMapper.findByStudentno(studentno);
    }

    @Override
    public List<String> findIdsByStudentno(String studentno) {
        List<String> list = new ArrayList<>();
        List<CourseInfoStudent> courseInfoStudent = this.findByStudentno(studentno);
        for (CourseInfoStudent cis : courseInfoStudent) {
            list.add(cis.getId());
            System.out.println("已选课程:");
            System.out.print(cis.getId());
        }
        return list;
    }

}
