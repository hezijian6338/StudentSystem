package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.LearningguidStudentslistMapper;
import com.Mrs.Wang.project.dao.StudentsMapper;
import com.Mrs.Wang.project.dao.TeacherInfoMapper;
import com.Mrs.Wang.project.model.LearningguidStudentslist;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.model.TeacherInfo;
import com.Mrs.Wang.project.service.LearningguidStudentslistService;
import com.Mrs.Wang.project.core.AbstractService;
import com.Mrs.Wang.project.service.StudentsService;
import com.Mrs.Wang.project.service.TeacherInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class LearningguidStudentslistServiceImpl extends AbstractService<LearningguidStudentslist> implements LearningguidStudentslistService {
    @Resource
    private LearningguidStudentslistMapper tLearningguidStudentslistMapper;

    @Resource
    private LearningguidStudentslistService learningguidStudentslistService;

    public void studentToEmployno(Students student, TeacherInfo teacherInfo){
        LearningguidStudentslist lgsl = new LearningguidStudentslist();
        lgsl.setId("164dfas65fas fasfsw 516");
        //创建者和创建时间还有学期等字段还有疑问
        lgsl.setStudentno(student.getStudentno());
        lgsl.setClassname(student.getClassname());
        lgsl.setStuId(student.getStuId());
        lgsl.setStuname(student.getStuname());
        lgsl.setAcademicyear(teacherInfo.getAcdemictitle());
        lgsl.setTeachername(teacherInfo.getEmployName());
        lgsl.setTeacherno(teacherInfo.getEmployNo());
        lgsl.setCreator(student.getStudentno());
        learningguidStudentslistService.save(lgsl);
    }

}
