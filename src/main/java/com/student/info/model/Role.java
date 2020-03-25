package com.student.info.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "Sys_Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Transient
    private List<Permission> permissions;



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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param permissions
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return permissions
     */
    public List<Permission> getPermissions() {
        return permissions;
    }
}