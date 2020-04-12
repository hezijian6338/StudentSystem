package com.student.info.model;

import javax.persistence.*;

@Table(name = "t_confirmguid_studentlist")
public class confirmList {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 学号
     */
    @Column(name = "STUDENTNO")
    private String studentno;

    /**
     * 学年
     */
    @Column(name = "ACADEMICYEAR")
    private String academicyear;

    /**
     * 学期
     */
    @Column(name = "TERM")
    private String term;

    /**
     * 导师工号
     */
    @Column(name = "TEACHERNO")
    private String teacherno;

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取学号
     *
     * @return STUDENTNO - 学号
     */
    public String getStudentno() {
        return studentno;
    }

    /**
     * 设置学号
     *
     * @param studentno 学号
     */
    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    /**
     * 获取学年
     *
     * @return ACADEMICYEAR - 学年
     */
    public String getAcademicyear() {
        return academicyear;
    }

    /**
     * 设置学年
     *
     * @param academicyear 学年
     */
    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    /**
     * 获取学期
     *
     * @return TERM - 学期
     */
    public String getTerm() {
        return term;
    }

    /**
     * 设置学期
     *
     * @param term 学期
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * 获取导师工号
     *
     * @return TEACHERNO - 导师工号
     */
    public String getTeacherno() {
        return teacherno;
    }

    /**
     * 设置导师工号
     *
     * @param teacherno 导师工号
     */
    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    /**
     * 获取状态
     *
     * @return STATUS - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}