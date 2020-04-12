package com.student.info.web;

import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.model.confirmList;
import com.student.info.service.confirmListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2020/04/11.
*/
@RestController
@RequestMapping("/confirm/list")
public class confirmListController {
    @Resource
    private confirmListService confirmListService;

    @PostMapping
    public Result add(@RequestBody confirmList confirmList) {
        confirmListService.save(confirmList);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        confirmListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody confirmList confirmList) {
        confirmListService.update(confirmList);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        confirmList confirmList = confirmListService.findById(id);
        return ResultGenerator.genSuccessResult(confirmList);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<confirmList> list = confirmListService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/unconfirm/{employno}")
    public Result RequestGuideTeacher(@PathVariable String employno) {
//        learningguidStudentslistService.studentReEmployno(id, employno);
        System.out.println("!@#%$^&*()_+" + employno + "!@#%$^&*()_+");
        return ResultGenerator.genSuccessResult();
    }
}
