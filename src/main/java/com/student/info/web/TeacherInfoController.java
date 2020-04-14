package com.student.info.web;

import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.model.TeacherInfo;
import com.student.info.service.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/teacher/info")
public class TeacherInfoController {
    @Resource
    private TeacherInfoService teacherInfoService;

    @PostMapping
    public Result add(@RequestBody TeacherInfo teacherInfo) {
        teacherInfoService.save(teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        teacherInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TeacherInfo teacherInfo) {
        teacherInfoService.update(teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TeacherInfo teacherInfo = teacherInfoService.findById(id);
        return ResultGenerator.genSuccessResult(teacherInfo);
    }

    @GetMapping("/{fieldfieldName}/{value}")
    public Result searchBy(@PathVariable String fieldfieldName, @PathVariable String value){
        TeacherInfo teacherInfo = teacherInfoService.findBy(fieldfieldName, value);
        return ResultGenerator.genSuccessResult(teacherInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TeacherInfo> list = teacherInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("teaInfo/{employNo}")
    public Result teacherInfo(@PathVariable String employNo) {
        String fieldfieldName = "employNo"; // EMPLOY_NO
        TeacherInfo teacherInfo = teacherInfoService.findBy(fieldfieldName, employNo);
        System.out.println(teacherInfo.getEmployName() + "********");
        return ResultGenerator.genSuccessResult(teacherInfo);
//        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/updateData/")
    public Result updateData(@RequestBody TeacherInfo teacherInfo) {
        System.out.println(teacherInfo.getEmployName());
//        teacherInfoService.update(teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

}
