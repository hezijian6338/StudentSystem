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
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class CourseInfoStudentServiceImpl extends AbstractService<CourseInfoStudent> implements CourseInfoStudentService {
    @Resource
    private CourseInfoStudentMapper tCourseinfoStudentsMapper;

    @Override
    public void studentToCourseCode(Students students, CourseInfo courseInfo) {
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
    public List<CourseInfoStudent> findByStudentno(String studentno) {
        return tCourseinfoStudentsMapper.findByStudentno(studentno);
    }

}
