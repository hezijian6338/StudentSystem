package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.TeacherInfo;
import com.Mrs.Wang.project.core.Service;


/**
 * Created by Dragonsking309 on 2018/11/19.
 * @author hezijian6338
 */
public interface TeacherInfoService extends Service<TeacherInfo> {

    /**
     * TODO: 根据老师工号来查找老师信息
     * @author hezijian6338
     * @date 2019/3/14 9:30
     * @param teacherno
     * @return com.Mrs.Wang.project.model.TeacherInfo
     * @throws
     **/

    public TeacherInfo findByTeacherno(String teacherno);

}
