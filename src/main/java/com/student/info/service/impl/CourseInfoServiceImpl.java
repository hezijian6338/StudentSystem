package com.student.info.service.impl;

import com.student.info.dao.CourseInfoMapper;
import com.student.info.model.CourseInfo;
import com.student.info.service.CourseInfoService;
import com.student.info.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends AbstractService<CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper tCourseinfoMapper;

    @Override
    public List<CourseInfo> findSelectedCoursesByTeacherNo(String teacherNo) {
        return tCourseinfoMapper.findSelectedCoursesByTeacherNo(teacherNo);
    }
}
