package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.model.UserRole;
import com.Mrs.Wang.project.service.UserRoleService;
import com.Mrs.Wang.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/user/role")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserService userService;

//    @PostMapping
//    public Result add(@RequestBody UserRole userRole) {
//        userRoleService.save(userRole);
//        return ResultGenerator.genSuccessResult();
//    }
    @PostMapping(produces = "application/json;charset=UTF-8")
    public Result editUserRole(@RequestBody User user) {
        userRoleService.editUserRole(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserRole userRole) {
        userRoleService.update(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        UserRole userRole = userRoleService.findById(id);
        return ResultGenerator.genSuccessResult(userRole);
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<UserRole> list = userRoleService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
    @GetMapping
    public Result findByUserName(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findUserRole();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
