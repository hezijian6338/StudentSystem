package com.Mrs.Wang.project.DTO;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于加载权限列表中的'角色-用户'关系
 * @author: hezijian6338
 * @create: 2018-12-11 15:15
 **/

public class RolesUserDTO {
    private String id;

    private String name;

    private List<UserDTO> username;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<UserDTO> getUsername() {
        return username;
    }

    public void setUsername(List<UserDTO> username) {
        this.username = username;
    }
}
