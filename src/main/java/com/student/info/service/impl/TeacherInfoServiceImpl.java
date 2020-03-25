package com.student.info.service.impl;

import com.student.info.dao.TeacherInfoMapper;
import com.student.info.model.TeacherInfo;
import com.student.info.service.TeacherInfoService;
import com.student.info.core.AbstractService;
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
