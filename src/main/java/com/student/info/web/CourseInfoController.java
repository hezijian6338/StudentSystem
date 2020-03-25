package com.student.info.web;

import com.student.info.DTO.CourseInfoStuCondition;
import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.dao.CourseInfoMapper;
import com.student.info.model.CourseInfo;
import com.student.info.service.CourseInfoService;
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

    /**
     * TODO: 返回有什么学年
     * @author hezijian6338
     * @date 2019/3/13 15:21
     * @param
     * @return Result
     * @throws
     **/

    @GetMapping("/condition/aca")
    public Result conditionOfAca() {
        return ResultGenerator.genSuccessResult(courseInfoMapper.conditionOfAca());
    }

    /**
     * TODO: 需要前端根据规定的DTO类来确定学生可选课的信息
     * @author hezijian6338
     * @date 2019/3/13 15:22
     * @param courseInfoStuCondition
     * @return Result
     * @throws
     **/

    @GetMapping("condition")
    public Result searchOfCondition(@RequestBody CourseInfoStuCondition courseInfoStuCondition) {
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
