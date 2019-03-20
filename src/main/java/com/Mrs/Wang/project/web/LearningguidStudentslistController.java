package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.LearningguidStudentslist;
import com.Mrs.Wang.project.model.Students;
import com.Mrs.Wang.project.model.TeacherInfo;
import com.Mrs.Wang.project.service.LearningguidStudentslistService;
import com.Mrs.Wang.project.service.StudentsService;
import com.Mrs.Wang.project.service.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/learningguid/studentslist")
public class LearningguidStudentslistController {
    @Resource
    private LearningguidStudentslistService learningguidStudentslistService;

    @Resource
    private StudentsService studentsService;

    @Resource
    private TeacherInfoService teacherInfoService;

    @PostMapping
    public Result add(@RequestBody LearningguidStudentslist learningguidStudentslist) {
        learningguidStudentslistService.save(learningguidStudentslist);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * TODO: 学生选导学老师
     * @author hezijian6338
     * @date  10:50
     * @param studentno
     *  * @param employno
     * @return com.Mrs.Wang.project.core.Result
     * @throws
     **/

    @PostMapping("/{studentno}/to/{employno}")
    public Result _add(@PathVariable String studentno, @PathVariable String employno) {
        Students students = studentsService.findBy("studentno", studentno);
        TeacherInfo teacherInfo = teacherInfoService.findBy("employNo", employno);
        learningguidStudentslistService.studentToEmployno(students, teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        learningguidStudentslistService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/{id}/{employno}")
    public Result update(@PathVariable String id, @PathVariable String employno) {
        learningguidStudentslistService.studentReEmployno(id, employno);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        LearningguidStudentslist learningguidStudentslist = learningguidStudentslistService.findById(id);
        return ResultGenerator.genSuccessResult(learningguidStudentslist);
    }

    @GetMapping("/{fieldName}/{value}")
    public Result findBy(@PathVariable String fieldName, @PathVariable String value) {
        LearningguidStudentslist learningguidStudentslist = learningguidStudentslistService.findBy(fieldName, value);
        return ResultGenerator.genSuccessResult(learningguidStudentslist);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LearningguidStudentslist> list = learningguidStudentslistService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
