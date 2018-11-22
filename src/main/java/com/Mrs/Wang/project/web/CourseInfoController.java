package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.CourseInfo;
import com.Mrs.Wang.project.model.TeacherInfo;
import com.Mrs.Wang.project.service.CourseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/course/info")
public class CourseInfoController {
    @Resource
    private CourseInfoService courseInfoService;

    @PostMapping
    public Result add(@RequestBody CourseInfo courseInfo) {
        courseInfoService.save(courseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        courseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody CourseInfo courseInfo) {
        courseInfoService.update(courseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CourseInfo courseInfo = courseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(courseInfo);
    }

    @GetMapping("/{fieldfieldName}/{value}")
    public Result searchBy(@PathVariable String fieldfieldName, @PathVariable String value){
        CourseInfo courseInfo = courseInfoService.findBy(fieldfieldName, value);
        return ResultGenerator.genSuccessResult(courseInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfo> list = courseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
