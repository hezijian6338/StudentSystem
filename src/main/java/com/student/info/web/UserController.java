package com.student.info.web;

import com.student.info.DTO.RolesDTO;
import com.student.info.DTO.UserDTO;
import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.dao.UserMapper;
import com.student.info.model.User;
import com.student.info.service.UserRoleService;
import com.student.info.service.UserService;
import com.student.info.utils.JWTUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private UserRoleService userRoleService;

    @Resource
    private UserMapper userMapper;


    @PostMapping("/login")
    public Result login(@RequestHeader String token) {
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/user/{number}")
    public Result add(@PathVariable String number) {
        User user = new User();
        user.setUsername(number);
        // 默认初始密码 admin
        user.setPassword(JWTUtils.setAuthentication("admin"));
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable Long id) {
        User user = userService.findById(id);

        // TODO: 删除角色依赖后再删除用户 (避免数据游离)
        user.setRoles(new ArrayList<>());
        userRoleService.editUserRole(user);

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

    @GetMapping("/user/name/{userName}")
    public Result findUserByName(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
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

    @PostMapping("/user/{id}/password/{oldPassword}/modification/{newPassword}")
    public Result userPasswordModify(@PathVariable Long id, @PathVariable String oldPassword, @PathVariable String newPassword) {
        User user = userService.findById(id);

        if (user == null)
            return ResultGenerator.genFailResult("用户为空, 请联系管理员~");

        if (user.getPassword() == null)
            return ResultGenerator.genFailResult("密码为空, 请联系管理员~");

        if (!JWTUtils.getAuthentication(user.getPassword()).equals(oldPassword))
            return ResultGenerator.genFailResult("旧密码错误~");

        // TODO: 加密密码并且存储
        user.setPassword(JWTUtils.setAuthentication(newPassword));
        userService.update(user);

        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/user/non/password")
    public Result findUserNonPw(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<String> list = userMapper.findUserNonPw();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
