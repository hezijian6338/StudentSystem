package com.student.info.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_courseinfo_students")
public class CourseInfoStudent {
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
     * 学院id
     */
    @Column(name = "ORG_ID")
    private String orgId;

    /**
     * 学院名称
     */
    @Column(name = "ORG_NAME")
    private String orgName;

    /**
     * 班级
     */
    @Column(name = "CLASSNAME")
    private String classname;

    /**
     * 专业代码
     */
    @Column(name = "MAJORCODE")
    private String majorcode;

    /**
     * 专业
     */
    @Column(name = "MAJOR")
    private String major;

    @Column(name = "RETAKEFLAG")
    private String retakeflag;

    /**
     * 平时成绩
     */
    @Column(name = "USUALSCORE")
    private String usualscore;

    /**
     * 期中成绩
     */
    @Column(name = "MIDDLESCORE")
    private String middlescore;

    /**
     * 期末成绩
     */
    @Column(name = "ENDSCORE")
    private String endscore;

    /**
     * 实验成绩
     */
    @Column(name = "LABSCORE")
    private String labscore;

    /**
     * 总评成绩
     */
    @Column(name = "FINALSCORE")
    private String finalscore;

    /**
     * 折算成绩
     */
    @Column(name = "CONVERTSCORE")
    private String convertscore;

    /**
     * 补考成绩
     */
    @Column(name = "RESITSCORE")
    private String resitscore;

    /**
     * 补考成绩备注
     */
    @Column(name = "RESITMEMO")
    private String resitmemo;

    /**
     * 重修成绩
     */
    @Column(name = "REPAIRSCORE")
    private String repairscore;

    /**
     * 绩点
     */
    @Column(name = "GRADEPOINT")
    private BigDecimal gradepoint;

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

    @Column(name = "PARENT_ORG_ID")
    private String parentOrgId;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "ACADEMICYEAR")
    private String academicyear;

    @Column(name = "TERM")
    private String term;

    @Column(name = "EMPLOY_NO")
    private String employNo;

    @Column(name = "EMPLOY_NAME")
    private String employName;

    @Column(name = "SELECTEDCOURSENO")
    private String selectedcourseno;

    @Column(name = "COURSETYPE")
    private String coursetype;

    @Column(name = "CREDIT")
    private BigDecimal credit;

    @Column(name = "TOTALHOURS")
    private BigDecimal totalhours;

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
     * 获取学院id
     *
     * @return ORG_ID - 学院id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置学院id
     *
     * @param orgId 学院id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取学院名称
     *
     * @return ORG_NAME - 学院名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置学院名称
     *
     * @param orgName 学院名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
     * 获取专业代码
     *
     * @return MAJORCODE - 专业代码
     */
    public String getMajorcode() {
        return majorcode;
    }

    /**
     * 设置专业代码
     *
     * @param majorcode 专业代码
     */
    public void setMajorcode(String majorcode) {
        this.majorcode = majorcode;
    }

    /**
     * 获取专业
     *
     * @return MAJOR - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return RETAKEFLAG
     */
    public String getRetakeflag() {
        return retakeflag;
    }

    /**
     * @param retakeflag
     */
    public void setRetakeflag(String retakeflag) {
        this.retakeflag = retakeflag;
    }

    /**
     * 获取平时成绩
     *
     * @return USUALSCORE - 平时成绩
     */
    public String getUsualscore() {
        return usualscore;
    }

    /**
     * 设置平时成绩
     *
     * @param usualscore 平时成绩
     */
    public void setUsualscore(String usualscore) {
        this.usualscore = usualscore;
    }

    /**
     * 获取期中成绩
     *
     * @return MIDDLESCORE - 期中成绩
     */
    public String getMiddlescore() {
        return middlescore;
    }

    /**
     * 设置期中成绩
     *
     * @param middlescore 期中成绩
     */
    public void setMiddlescore(String middlescore) {
        this.middlescore = middlescore;
    }

    /**
     * 获取期末成绩
     *
     * @return ENDSCORE - 期末成绩
     */
    public String getEndscore() {
        return endscore;
    }

    /**
     * 设置期末成绩
     *
     * @param endscore 期末成绩
     */
    public void setEndscore(String endscore) {
        this.endscore = endscore;
    }

    /**
     * 获取实验成绩
     *
     * @return LABSCORE - 实验成绩
     */
    public String getLabscore() {
        return labscore;
    }

    /**
     * 设置实验成绩
     *
     * @param labscore 实验成绩
     */
    public void setLabscore(String labscore) {
        this.labscore = labscore;
    }

    /**
     * 获取总评成绩
     *
     * @return FINALSCORE - 总评成绩
     */
    public String getFinalscore() {
        return finalscore;
    }

    /**
     * 设置总评成绩
     *
     * @param finalscore 总评成绩
     */
    public void setFinalscore(String finalscore) {
        this.finalscore = finalscore;
    }

    /**
     * 获取折算成绩
     *
     * @return CONVERTSCORE - 折算成绩
     */
    public String getConvertscore() {
        return convertscore;
    }

    /**
     * 设置折算成绩
     *
     * @param convertscore 折算成绩
     */
    public void setConvertscore(String convertscore) {
        this.convertscore = convertscore;
    }

    /**
     * 获取补考成绩
     *
     * @return RESITSCORE - 补考成绩
     */
    public String getResitscore() {
        return resitscore;
    }

    /**
     * 设置补考成绩
     *
     * @param resitscore 补考成绩
     */
    public void setResitscore(String resitscore) {
        this.resitscore = resitscore;
    }

    /**
     * 获取补考成绩备注
     *
     * @return RESITMEMO - 补考成绩备注
     */
    public String getResitmemo() {
        return resitmemo;
    }

    /**
     * 设置补考成绩备注
     *
     * @param resitmemo 补考成绩备注
     */
    public void setResitmemo(String resitmemo) {
        this.resitmemo = resitmemo;
    }

    /**
     * 获取重修成绩
     *
     * @return REPAIRSCORE - 重修成绩
     */
    public String getRepairscore() {
        return repairscore;
    }

    /**
     * 设置重修成绩
     *
     * @param repairscore 重修成绩
     */
    public void setRepairscore(String repairscore) {
        this.repairscore = repairscore;
    }

    /**
     * 获取绩点
     *
     * @return GRADEPOINT - 绩点
     */
    public BigDecimal getGradepoint() {
        return gradepoint;
    }

    /**
     * 设置绩点
     *
     * @param gradepoint 绩点
     */
    public void setGradepoint(BigDecimal gradepoint) {
        this.gradepoint = gradepoint;
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
     * @return PARENT_ORG_ID
     */
    public String getParentOrgId() {
        return parentOrgId;
    }

    /**
     * @param parentOrgId
     */
    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    /**
     * @return GRADE
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return ACADEMICYEAR
     */
    public String getAcademicyear() {
        return academicyear;
    }

    /**
     * @param academicyear
     */
    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    /**
     * @return TERM
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return EMPLOY_NO
     */
    public String getEmployNo() {
        return employNo;
    }

    /**
     * @param employNo
     */
    public void setEmployNo(String employNo) {
        this.employNo = employNo;
    }

    /**
     * @return EMPLOY_NAME
     */
    public String getEmployName() {
        return employName;
    }

    /**
     * @param employName
     */
    public void setEmployName(String employName) {
        this.employName = employName;
    }

    /**
     * @return SELECTEDCOURSENO
     */
    public String getSelectedcourseno() {
        return selectedcourseno;
    }

    /**
     * @param selectedcourseno
     */
    public void setSelectedcourseno(String selectedcourseno) {
        this.selectedcourseno = selectedcourseno;
    }

    /**
     * @return COURSETYPE
     */
    public String getCoursetype() {
        return coursetype;
    }

    /**
     * @param coursetype
     */
    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    /**
     * @return CREDIT
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * @param credit
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    /**
     * @return TOTALHOURS
     */
    public BigDecimal getTotalhours() {
        return totalhours;
    }

    /**
     * @param totalhours
     */
    public void setTotalhours(BigDecimal totalhours) {
        this.totalhours = totalhours;
    }
}