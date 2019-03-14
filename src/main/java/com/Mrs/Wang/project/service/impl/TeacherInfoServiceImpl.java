package com.Mrs.Wang.project.service.impl;

import com.Mrs.Wang.project.dao.TeacherInfoMapper;
import com.Mrs.Wang.project.model.TeacherInfo;
import com.Mrs.Wang.project.service.TeacherInfoService;
import com.Mrs.Wang.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2018/11/19.
 * @author hezijian6338
 */
@Service
@Transactional
public class TeacherInfoServiceImpl extends AbstractService<TeacherInfo> implements TeacherInfoService {
    @Resource
    private TeacherInfoMapper tTeacherinfoMapper;

    @Override
    public TeacherInfo findByTeacherno(String teacherno) {
        return tTeacherinfoMapper.findByTeacherno(teacherno);
    }

}
