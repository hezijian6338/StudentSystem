package com.Mrs.Wang.project.core;

/**
 * @program: spring-boot-api-project-seed
 * @description: 枚举角色列表
 * @author: hezijian6338
 * @create: 2018-12-14 10:27
 **/

public enum RoleCode {
    ROLE_ADMIN(1),//管理员
    ROLE_TEACHER(3),//老师
    ROLE_STUDENT(4),//学生
    ROLE_USER(2);//普通用户

    private final int code;

    RoleCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
