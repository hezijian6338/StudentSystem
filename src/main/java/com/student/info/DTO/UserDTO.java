package com.student.info.DTO;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于根据角色查询用户列表返回不含密码参数的对象
 * @author: hezijian6338
 * @create: 2018-11-22 14:56
 **/

public class UserDTO {
    private Long id;

    private String name;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
