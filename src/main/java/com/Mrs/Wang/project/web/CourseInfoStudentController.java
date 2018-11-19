package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.CourseInfoStudent;
import com.Mrs.Wang.project.service.CourseInfoStudentService;
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

    @PostMapping
    public Result add(@RequestBody CourseInfoStudent courseInfoStudent) {
        courseInfoStudentService.save(courseInfoStudent);
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

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CourseInfoStudent courseInfoStudent = courseInfoStudentService.findById(id);
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
