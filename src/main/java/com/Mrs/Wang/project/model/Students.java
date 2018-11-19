package com.Mrs.Wang.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_students")
public class Students {
    @Id
    @Column(name = "STU_ID")
    private String stuId;

    /**
     * 学号
     */
    @Column(name = "STUDENTNO")
    private String studentno;

    @Column(name = "STUNAME")
    private String stuname;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 政治面貌
     */
    @Column(name = "POLITICALSTATUS")
    private String politicalstatus;

    /**
     * 民族
     */
    @Column(name = "NATION")
    private String nation;

    /**
     * 籍贯
     */
    @Column(name = "NATIVEPLACE")
    private String nativeplace;

    /**
     * 来源地区
     */
    @Column(name = "FROM_PLACE")
    private String fromPlace;

    /**
     * 身份证号码
     */
    @Column(name = "IDCARDNO")
    private String idcardno;

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
     * 专业
     */
    @Column(name = "MAJOR")
    private String major;

    /**
     * 专业方向
     */
    @Column(name = "MAJORFIELD")
    private String majorfield;

    /**
     * 专业类别
     */
    @Column(name = "MAJORCATEGORIES")
    private String majorcategories;

    /**
     * 班级
     */
    @Column(name = "CLASSNAME")
    private String classname;

    /**
     * 学制
     */
    @Column(name = "EDUCATIONSYSTEM")
    private BigDecimal educationsystem;

    /**
     * 学习年限
     */
    @Column(name = "SCHOOLINGLENGTH")
    private BigDecimal schoolinglength;

    /**
     * 入学日期
     */
    @Column(name = "ACCEPTANCEDATE")
    private Date acceptancedate;

    /**
     * 毕业中学
     */
    @Column(name = "MIDDLESCHOOL")
    private String middleschool;

    /**
     * 本人电话
     */
    @Column(name = "FAMILYTELNO")
    private String familytelno;

    @Column(name = "MOBILENO")
    private String mobileno;

    /**
     * 邮政编码
     */
    @Column(name = "POSTCODE")
    private String postcode;

    /**
     * 乘车区间
     */
    @Column(name = "TRAVELRANGE")
    private String travelrange;

    /**
     * 家庭地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 学籍状态
     */
    @Column(name = "SCHOOLSTATUS")
    private String schoolstatus;

    @Column(name = "PHOTOPATH")
    private String photopath;

    /**
     * 登录密码
     */
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MAJOR_CODE")
    private String majorCode;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SCORE")
    private BigDecimal score;

    @Column(name = "GRADE")
    private String grade;

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
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取政治面貌
     *
     * @return POLITICALSTATUS - 政治面貌
     */
    public String getPoliticalstatus() {
        return politicalstatus;
    }

    /**
     * 设置政治面貌
     *
     * @param politicalstatus 政治面貌
     */
    public void setPoliticalstatus(String politicalstatus) {
        this.politicalstatus = politicalstatus;
    }

    /**
     * 获取民族
     *
     * @return NATION - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取籍贯
     *
     * @return NATIVEPLACE - 籍贯
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * 设置籍贯
     *
     * @param nativeplace 籍贯
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**
     * 获取来源地区
     *
     * @return FROM_PLACE - 来源地区
     */
    public String getFromPlace() {
        return fromPlace;
    }

    /**
     * 设置来源地区
     *
     * @param fromPlace 来源地区
     */
    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    /**
     * 获取身份证号码
     *
     * @return IDCARDNO - 身份证号码
     */
    public String getIdcardno() {
        return idcardno;
    }

    /**
     * 设置身份证号码
     *
     * @param idcardno 身份证号码
     */
    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
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
     * 获取专业方向
     *
     * @return MAJORFIELD - 专业方向
     */
    public String getMajorfield() {
        return majorfield;
    }

    /**
     * 设置专业方向
     *
     * @param majorfield 专业方向
     */
    public void setMajorfield(String majorfield) {
        this.majorfield = majorfield;
    }

    /**
     * 获取专业类别
     *
     * @return MAJORCATEGORIES - 专业类别
     */
    public String getMajorcategories() {
        return majorcategories;
    }

    /**
     * 设置专业类别
     *
     * @param majorcategories 专业类别
     */
    public void setMajorcategories(String majorcategories) {
        this.majorcategories = majorcategories;
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
     * 获取学制
     *
     * @return EDUCATIONSYSTEM - 学制
     */
    public BigDecimal getEducationsystem() {
        return educationsystem;
    }

    /**
     * 设置学制
     *
     * @param educationsystem 学制
     */
    public void setEducationsystem(BigDecimal educationsystem) {
        this.educationsystem = educationsystem;
    }

    /**
     * 获取学习年限
     *
     * @return SCHOOLINGLENGTH - 学习年限
     */
    public BigDecimal getSchoolinglength() {
        return schoolinglength;
    }

    /**
     * 设置学习年限
     *
     * @param schoolinglength 学习年限
     */
    public void setSchoolinglength(BigDecimal schoolinglength) {
        this.schoolinglength = schoolinglength;
    }

    /**
     * 获取入学日期
     *
     * @return ACCEPTANCEDATE - 入学日期
     */
    public Date getAcceptancedate() {
        return acceptancedate;
    }

    /**
     * 设置入学日期
     *
     * @param acceptancedate 入学日期
     */
    public void setAcceptancedate(Date acceptancedate) {
        this.acceptancedate = acceptancedate;
    }

    /**
     * 获取毕业中学
     *
     * @return MIDDLESCHOOL - 毕业中学
     */
    public String getMiddleschool() {
        return middleschool;
    }

    /**
     * 设置毕业中学
     *
     * @param middleschool 毕业中学
     */
    public void setMiddleschool(String middleschool) {
        this.middleschool = middleschool;
    }

    /**
     * 获取本人电话
     *
     * @return FAMILYTELNO - 本人电话
     */
    public String getFamilytelno() {
        return familytelno;
    }

    /**
     * 设置本人电话
     *
     * @param familytelno 本人电话
     */
    public void setFamilytelno(String familytelno) {
        this.familytelno = familytelno;
    }

    /**
     * @return MOBILENO
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * 获取邮政编码
     *
     * @return POSTCODE - 邮政编码
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮政编码
     *
     * @param postcode 邮政编码
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取乘车区间
     *
     * @return TRAVELRANGE - 乘车区间
     */
    public String getTravelrange() {
        return travelrange;
    }

    /**
     * 设置乘车区间
     *
     * @param travelrange 乘车区间
     */
    public void setTravelrange(String travelrange) {
        this.travelrange = travelrange;
    }

    /**
     * 获取家庭地址
     *
     * @return ADDRESS - 家庭地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置家庭地址
     *
     * @param address 家庭地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取学籍状态
     *
     * @return SCHOOLSTATUS - 学籍状态
     */
    public String getSchoolstatus() {
        return schoolstatus;
    }

    /**
     * 设置学籍状态
     *
     * @param schoolstatus 学籍状态
     */
    public void setSchoolstatus(String schoolstatus) {
        this.schoolstatus = schoolstatus;
    }

    /**
     * @return PHOTOPATH
     */
    public String getPhotopath() {
        return photopath;
    }

    /**
     * @param photopath
     */
    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    /**
     * 获取登录密码
     *
     * @return PASSWORD - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return MAJOR_CODE
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * @param majorCode
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return SCORE
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(BigDecimal score) {
        this.score = score;
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
}