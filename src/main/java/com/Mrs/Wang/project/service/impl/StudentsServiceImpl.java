package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.StudentsMapper;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.service.StudentsService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@Service
@Transactional
public class StudentsServiceImpl extends AbstractService<Students> implements StudentsService {
    @Resource
    private StudentsMapper tStudentsMapper;

}
