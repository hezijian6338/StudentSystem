package com.student.info.service;
import com.student.info.model.LearningguidStudentslist;
import com.student.info.core.Service;
import com.student.info.model.Students;
import com.student.info.model.TeacherInfo;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface LearningguidStudentslistService extends Service<LearningguidStudentslist> {

    /**
     * TODO: 根据学生的学号和老师的工号进行导学选择
     * @author hezijian6338
     * @date 2019/3/20 15:22
     * @param studentno
      * @param employno
     * @return void
     * @throws
     **/

    public void studentToEmployno(Students studentno, TeacherInfo employno);

    /**
     * TODO: 学生重新选择导师(其实这种情况应该不存在)
     * @author hezijian6338
     * @date 2019/3/20 15:25
     * @param id
     * @param employno
     * @return void
     * @throws
     **/

    public void studentReEmployno(String id, String employno);
}
