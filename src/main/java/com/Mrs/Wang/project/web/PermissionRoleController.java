package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.model.PermissionRole;
import com.Mrs.Wang.project.model.Role;
import com.Mrs.Wang.project.service.PermissionRoleService;
import com.Mrs.Wang.project.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Dragonsking309 on 2018/11/19.
*/
@RestController
@RequestMapping("/permission/role")
public class PermissionRoleController {
    @Resource
    private PermissionRoleService permissionRoleService;

    @Resource
    private RoleService roleService;

    @PostMapping
    public Result add(@RequestBody PermissionRole permissionRole) {
        permissionRoleService.save(permissionRole);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        permissionRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody PermissionRole permissionRole) {
        permissionRoleService.update(permissionRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        PermissionRole permissionRole = permissionRoleService.findById(id);
        return ResultGenerator.genSuccessResult(permissionRole);
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<PermissionRole> list = permissionRoleService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @GetMapping
    public Result findRoleWithPermission(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Role> list = roleService.findRoleWithPermission();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
