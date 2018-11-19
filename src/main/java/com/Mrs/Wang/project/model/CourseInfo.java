package com.Mrs.Wang.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_courseinfo")
public class CourseInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 课程代码
     */
    @Column(name = "COURSECODE")
    private String coursecode;

    /**
     * 课程名称
     */
    @Column(name = "COURSENAME")
    private String coursename;

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
     * 教师工号
     */
    @Column(name = "EMPLOY_NO")
    private String employNo;

    /**
     * 教师姓名
     */
    @Column(name = "EMPLOY_NAME")
    private String employName;

    /**
     * 选课课号

     */
    @Column(name = "SELECTEDCOURSENO")
    private String selectedcourseno;

    /**
     * 课程性质
     */
    @Column(name = "COURSETYPE")
    private String coursetype;

    /**
     * 总学时
     */
    @Column(name = "TOTALHOURS")
    private BigDecimal totalhours;

    /**
     * 选课人数
     */
    @Column(name = "STUDENTNUM")
    private BigDecimal studentnum;

    /**
     * 学分：可根据总学时除以16进行换算得到该值
     */
    @Column(name = "CREDIT")
    private BigDecimal credit;

    /**
     * 课程归属：该值在导入的学生成绩明细中
     */
    @Column(name = "BELONGTO")
    private String belongto;

    @Column(name = "MEMO")
    private String memo;

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

    @Column(name = "LIMITSTUDENTNUM")
    private Long limitstudentnum;

    /**
     * 教学班组成
     */
    @Column(name = "CLASSINFO")
    private String classinfo;

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
     * 获取课程代码
     *
     * @return COURSECODE - 课程代码
     */
    public String getCoursecode() {
        return coursecode;
    }

    /**
     * 设置课程代码
     *
     * @param coursecode 课程代码
     */
    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    /**
     * 获取课程名称
     *
     * @return COURSENAME - 课程名称
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * 设置课程名称
     *
     * @param coursename 课程名称
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename;
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
     * 获取教师工号
     *
     * @return EMPLOY_NO - 教师工号
     */
    public String getEmployNo() {
        return employNo;
    }

    /**
     * 设置教师工号
     *
     * @param employNo 教师工号
     */
    public void setEmployNo(String employNo) {
        this.employNo = employNo;
    }

    /**
     * 获取教师姓名
     *
     * @return EMPLOY_NAME - 教师姓名
     */
    public String getEmployName() {
        return employName;
    }

    /**
     * 设置教师姓名
     *
     * @param employName 教师姓名
     */
    public void setEmployName(String employName) {
        this.employName = employName;
    }

    /**
     * 获取选课课号

     *
     * @return SELECTEDCOURSENO - 选课课号

     */
    public String getSelectedcourseno() {
        return selectedcourseno;
    }

    /**
     * 设置选课课号

     *
     * @param selectedcourseno 选课课号

     */
    public void setSelectedcourseno(String selectedcourseno) {
        this.selectedcourseno = selectedcourseno;
    }

    /**
     * 获取课程性质
     *
     * @return COURSETYPE - 课程性质
     */
    public String getCoursetype() {
        return coursetype;
    }

    /**
     * 设置课程性质
     *
     * @param coursetype 课程性质
     */
    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    /**
     * 获取总学时
     *
     * @return TOTALHOURS - 总学时
     */
    public BigDecimal getTotalhours() {
        return totalhours;
    }

    /**
     * 设置总学时
     *
     * @param totalhours 总学时
     */
    public void setTotalhours(BigDecimal totalhours) {
        this.totalhours = totalhours;
    }

    /**
     * 获取选课人数
     *
     * @return STUDENTNUM - 选课人数
     */
    public BigDecimal getStudentnum() {
        return studentnum;
    }

    /**
     * 设置选课人数
     *
     * @param studentnum 选课人数
     */
    public void setStudentnum(BigDecimal studentnum) {
        this.studentnum = studentnum;
    }

    /**
     * 获取学分：可根据总学时除以16进行换算得到该值
     *
     * @return CREDIT - 学分：可根据总学时除以16进行换算得到该值
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * 设置学分：可根据总学时除以16进行换算得到该值
     *
     * @param credit 学分：可根据总学时除以16进行换算得到该值
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    /**
     * 获取课程归属：该值在导入的学生成绩明细中
     *
     * @return BELONGTO - 课程归属：该值在导入的学生成绩明细中
     */
    public String getBelongto() {
        return belongto;
    }

    /**
     * 设置课程归属：该值在导入的学生成绩明细中
     *
     * @param belongto 课程归属：该值在导入的学生成绩明细中
     */
    public void setBelongto(String belongto) {
        this.belongto = belongto;
    }

    /**
     * @return MEMO
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
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

    /**
     * @return LIMITSTUDENTNUM
     */
    public Long getLimitstudentnum() {
        return limitstudentnum;
    }

    /**
     * @param limitstudentnum
     */
    public void setLimitstudentnum(Long limitstudentnum) {
        this.limitstudentnum = limitstudentnum;
    }

    /**
     * 获取教学班组成
     *
     * @return CLASSINFO - 教学班组成
     */
    public String getClassinfo() {
        return classinfo;
    }

    /**
     * 设置教学班组成
     *
     * @param classinfo 教学班组成
     */
    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }
}