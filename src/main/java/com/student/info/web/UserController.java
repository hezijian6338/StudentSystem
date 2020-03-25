package com.student.info.web;

import com.student.info.DTO.RolesDTO;
import com.student.info.DTO.UserDTO;
import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.dao.UserMapper;
import com.student.info.model.User;
import com.student.info.service.UserService;
import com.student.info.utils.JWTUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    @PostMapping("/login")
    public Result login(@RequestHeader String token) {
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/user")
    public Result add(@RequestBody User user) {
        // 默认初始密码 admin
        user.setPassword(JWTUtils.setAuthentication("admin"));
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/user")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/user/{id}")
    public Result detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping("/user/rolename/{rolename}")
    public Result searchByRole(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @PathVariable String rolename) {
        PageHelper.startPage(page, size);
        List<UserDTO> list = userMapper.findByRoleName(rolename);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/user/name")
    public Result searchRoleByuser(@RequestParam String token) {
        String username = JWTUtils.getAuthentication(token);
        List<String> list = userService.searchRoleByuser(username);
        RolesDTO roles = new RolesDTO();
        roles.setRoles(list);
        roles.setName(username);
        return ResultGenerator.genSuccessResult(roles);
    }

    @GetMapping("/user")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/user/non/password")
    public Result findUserNonPw(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<String> list = userMapper.findUserNonPw();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}