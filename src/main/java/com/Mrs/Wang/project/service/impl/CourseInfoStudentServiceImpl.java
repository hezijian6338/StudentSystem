package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.CourseInfoStudentMapper;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import com.Mrs.Wang.project.service.CourseInfoStudentService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class CourseInfoStudentServiceImpl extends AbstractService<CourseInfoStudent> implements CourseInfoStudentService {
    @Resource
    private CourseInfoStudentMapper tCourseinfoStudentsMapper;

}
