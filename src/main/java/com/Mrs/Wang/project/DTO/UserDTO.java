package com.Mrs.Wang.project.DTO;

import com.Mrs.Wang.project.model.Role;

import javax.persistence.*;
import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于根据角色查询用户列表返回不含密码参数的对象
 * @author: hezijian6338
 * @create: 2018-11-22 14:56
 **/

public class UserDTO {
        private Long id;

        private String username;

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

        /**
         * @return username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username
         */
        public void setUsername(String username) {
            this.username = username;
        }

}
