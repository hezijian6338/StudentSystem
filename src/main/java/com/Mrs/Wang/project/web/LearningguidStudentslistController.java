package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.LearningguidStudentslist;
import com.Mrs.Wang.project.service.LearningguidStudentslistService;
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

    @PostMapping
    public Result add(@RequestBody LearningguidStudentslist learningguidStudentslist) {
        learningguidStudentslistService.save(learningguidStudentslist);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        learningguidStudentslistService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody LearningguidStudentslist learningguidStudentslist) {
        learningguidStudentslistService.update(learningguidStudentslist);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        LearningguidStudentslist learningguidStudentslist = learningguidStudentslistService.findById(id);
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
