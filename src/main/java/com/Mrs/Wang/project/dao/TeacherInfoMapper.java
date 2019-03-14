package com.Mrs.Wang.project.dao;

import com.Mrs.Wang.project.core.Mapper;
import com.Mrs.Wang.project.model.TeacherInfo;

/**
 * @author hezijian6338
 **/

public interface TeacherInfoMapper extends Mapper<TeacherInfo> {

    /**
     * TODO: 根据老师工号查找老师信息
     * @author hezijian6338
     * @date 2019/3/14 9:32
     * @param teacherno
     * @return com.Mrs.Wang.project.model.TeacherInfo
     * @throws
     **/

    public TeacherInfo findByTeacherno(String teacherno);

}