package com.student.info.dao;

import com.student.info.core.Mapper;
import com.student.info.model.LearningguidStudentslist;

import java.util.List;

public interface LearningguidStudentslistMapper extends Mapper<LearningguidStudentslist> {
    List<LearningguidStudentslist> findByTeacherNo(String teacherNo);
}