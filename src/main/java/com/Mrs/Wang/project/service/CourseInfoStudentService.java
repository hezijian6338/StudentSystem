package com.Mrs.Wang.project.service;

import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import com.Mrs.Wang.project.core.Service;
import com.Mrs.Wang.project.model.Students;

import java.util.List;


/**
 * Created by Dragonsking309 on 2018/11/19.
 */
public interface CourseInfoStudentService extends Service<CourseInfoStudent> {
    public void studentToCourseCodes(String studentno, List<String> courseids);
    public List<CourseInfoStudent> findByStudentno(String studentno);
}
