package com.student.info.service.impl;

import com.student.info.model.LearningguidStudentslist;
import com.student.info.model.Students;
import com.student.info.model.TeacherInfo;
import com.student.info.service.LearningguidStudentslistService;
import com.student.info.core.AbstractService;
import com.student.info.service.StudentsService;
import com.student.info.service.TeacherInfoService;
import com.student.info.utils.UUIDUtils;
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
    private LearningguidStudentslistService learningguidStudentslistService;

    @Resource
    private StudentsService studentsService;

    @Resource
    private TeacherInfoService teacherInfoService;

    @Override
    public void studentToEmployno(Students student, TeacherInfo teacherInfo){
        LearningguidStudentslist lgsl = new LearningguidStudentslist();
        lgsl.setId(UUIDUtils.getUUID());
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

    @Override
    public void studentReEmployno(String id, String employno) {
        LearningguidStudentslist lgsl = this.findBy("id", id);
        TeacherInfo teacherInfo = teacherInfoService.findByTeacherno(employno);
        lgsl.setTeachername(teacherInfo.getEmployName());
        lgsl.setTeacherno(teacherInfo.getEmployNo());
        learningguidStudentslistService.update(lgsl);
    }

}
