package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.DTO.CourseInfoStuCondition;
import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.dao.CourseInfoMapper;
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

    @Resource
    private CourseInfoMapper courseInfoMapper;

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

    @GetMapping("condition/{aca}/{courseType}/{term}/{credit}/{className}")
    public Result searchOfCondition(@PathVariable String aca, @PathVariable String courseType, @PathVariable String term, @PathVariable String credit, @PathVariable String className) {
        CourseInfoStuCondition courseInfoStuCondition = new CourseInfoStuCondition();
        courseInfoStuCondition.setAca(aca);
        courseInfoStuCondition.setClassInfo(courseType);
        courseInfoStuCondition.setTerm(term);
        courseInfoStuCondition.setCredit(credit);
        courseInfoStuCondition.setCourseType(courseType);
        List<CourseInfo> courseInfos = courseInfoMapper.searchByCondition(courseInfoStuCondition);
        return ResultGenerator.genSuccessResult(courseInfos);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfo> list = courseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
