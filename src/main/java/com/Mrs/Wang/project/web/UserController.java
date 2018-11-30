package com.Mrs.Wang.project.web;

import com.Mrs.Wang.project.DTO.UserDTO;
import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultGenerator;
import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.User;
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

    @GetMapping("user/rolename/{rolename}")
    public Result searchByRole(@PathVariable String rolename) {
        List<UserDTO> list = userMapper.findByRoleName(rolename);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("user/role/{username}")
    public Result searchRoleByuser(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @PathVariable String username) {
        PageHelper.startPage(page, size);
        List<String> list = userService.searchRoleByuser(username);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/user")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
