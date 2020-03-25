package com.student.info.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_learningguid_studentslist")
public class LearningguidStudentslist {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "STU_ID")
    private String stuId;

    /**
     * 学号
     */
    @Column(name = "STUDENTNO")
    private String studentno;

    @Column(name = "STUNAME")
    private String stuname;

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
     * 班级
     */
    @Column(name = "CLASSNAME")
    private String classname;

    /**
     * 导师工号
     */
    @Column(name = "TEACHERNO")
    private String teacherno;

    /**
     * 导师姓名
     */
    @Column(name = "TEACHERNAME")
    private String teachername;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建者
     */
    @Column(name = "CREATOR")
    private String creator;

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
     * @return STU_ID
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * @param stuId
     */
    public void setStuId(String stuId) {
        this.stuId = stuId;
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
     * @return STUNAME
     */
    public String getStuname() {
        return stuname;
    }

    /**
     * @param stuname
     */
    public void setStuname(String stuname) {
        this.stuname = stuname;
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
     * 获取班级
     *
     * @return CLASSNAME - 班级
     */
    public String getClassname() {
        return classname;
    }

    /**
     * 设置班级
     *
     * @param classname 班级
     */
    public void setClassname(String classname) {
        this.classname = classname;
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
     * 获取导师姓名
     *
     * @return TEACHERNAME - 导师姓名
     */
    public String getTeachername() {
        return teachername;
    }

    /**
     * 设置导师姓名
     *
     * @param teachername 导师姓名
     */
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建者
     *
     * @return CREATOR - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }
}