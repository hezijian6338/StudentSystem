package com.student.info.web;

import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.dao.CourseInfoStudentMapper;
import com.student.info.model.CourseInfoStudent;
import com.student.info.service.CourseInfoService;
import com.student.info.service.CourseInfoStudentService;
import com.student.info.service.StudentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/course/info/student")
public class CourseInfoStudentController {
    @Resource
    private CourseInfoStudentService courseInfoStudentService;

    @Resource
    private StudentsService studentsService;

    @Resource
    private CourseInfoService courseInfoService;

    @Resource
    private CourseInfoStudentMapper courseInfoStudentMapper;

    @PostMapping
    public Result add(@RequestBody CourseInfoStudent courseInfoStudent) {
        courseInfoStudentService.save(courseInfoStudent);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/{studentno}")
    public Result _add(@PathVariable String studentno, @RequestBody List<String> courseids) {
        courseInfoStudentService.studentToCourseIds(studentno,courseids);
        return ResultGenerator.genSuccessResult();
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        courseInfoStudentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody CourseInfoStudent courseInfoStudent) {
        courseInfoStudentService.update(courseInfoStudent);
        return ResultGenerator.genSuccessResult();
    }

//    @GetMapping("/{id}")
//    public Result detail(@PathVariable Integer id) {
//        CourseInfoStudent courseInfoStudent = courseInfoStudentService.findById(id);
    
    /**
     * TODO: 根据学生学号查找已选的课程
     * @author hezijian6338
     * @date 2019/3/18
     * @param studentno
     * @return Result
     */

    @GetMapping("/detail/{studentno}")
    public Result findByStudentno(@PathVariable String studentno) {
        List<CourseInfoStudent> courseInfoStudent = courseInfoStudentService.findByStudentno(studentno);
        System.out.println(studentno + "Hello World");
        return ResultGenerator.genSuccessResult(courseInfoStudent);
    }

    @GetMapping("/{studentno}/ids")
    public Result findIdsByStudentno(@PathVariable String studentno) {
        List<String> list = courseInfoStudentService.findIdsByStudentno(studentno);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/{fieldName}/{value}")
    public Result searchBy(@PathVariable String fieldName, @PathVariable String value){
        CourseInfoStudent courseInfoStudent = courseInfoStudentService.findBy(fieldName, value);
        return ResultGenerator.genSuccessResult(courseInfoStudent);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfoStudent> list = courseInfoStudentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
