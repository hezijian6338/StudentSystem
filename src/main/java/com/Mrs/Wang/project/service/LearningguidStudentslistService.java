package com.Mrs.Wang.project.service;
import com.Mrs.Wang.project.model.LearningguidStudentslist;
import com.Mrs.Wang.project.core.Service;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.model.TeacherInfo;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface LearningguidStudentslistService extends Service<LearningguidStudentslist> {
    public void studentToEmployno(Students studentno, TeacherInfo employno);
}
