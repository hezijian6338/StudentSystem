package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.CourseInfoMapper;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.service.CourseInfoService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends AbstractService<CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper tCourseinfoMapper;

}
