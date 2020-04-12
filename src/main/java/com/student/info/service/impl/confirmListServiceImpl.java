package com.student.info.service.impl;

import com.student.info.dao.confirmListMapper;
import com.student.info.model.confirmList;
import com.student.info.service.confirmListService;
import com.student.info.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Dragonsking309 on 2020/04/11.
 */
@Service
@Transactional
public class confirmListServiceImpl extends AbstractService<confirmList> implements confirmListService {
    @Resource
    private confirmListMapper tConfirmguidStudentlistMapper;

}
