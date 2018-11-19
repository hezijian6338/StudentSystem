package com.Mrs.Wang.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_teacherinfo")
public class TeacherInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
     * 性别
     */
    @Column(name = "SEX")
    private String sex;

    /**
     * 出生日期
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

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
     * 系（科室）
     */
    @Column(name = "DEPARTMENT")
    private String department;

    /**
     * 联系电话
     */
    @Column(name = "TELNO")
    private String telno;

    /**
     * E_mail地址
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 联系地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 教职工类别
     */
    @Column(name = "CATEGORY")
    private String category;

    /**
     * 学历
     */
    @Column(name = "EDUCATION")
    private String education;

    /**
     * 学位
     */
    @Column(name = "DEGREE")
    private String degree;

    /**
     * 职务
     */
    @Column(name = "DUTY")
    private String duty;

    /**
     * 职称
     */
    @Column(name = "ACDEMICTITLE")
    private String acdemictitle;

    /**
     * 可否监考：T：可以；F：不可以
     */
    @Column(name = "INVIGILATORFLAG")
    private String invigilatorflag;

    /**
     * 研究方向
     */
    @Column(name = "RESEARCHDIRECTION")
    private String researchdirection;

    /**
     * 专业
     */
    @Column(name = "MAJOR")
    private String major;

    /**
     * 毕业院校
     */
    @Column(name = "GRADUATE")
    private String graduate;

    /**
     * 教师资格标志：Y:有；N：无
     */
    @Column(name = "QUALIFICATIONFLAG")
    private String qualificationflag;

    /**
     * 在职状态：Y:在职；N：离职
     */
    @Column(name = "JOBSTATUS")
    private String jobstatus;

    /**
     * 教师级别
     */
    @Column(name = "TEACHER_LEVEL")
    private String teacherLevel;

    /**
     * 是否实验室人员：Y：是；N：否
     */
    @Column(name = "ISLAB")
    private String islab;

    /**
     * 是否外聘
     */
    @Column(name = "ISOUTHIRE")
    private String isouthire;

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
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建者
     */
    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHOTOPATH")
    private String photopath;

    @Column(name = "PARENT_ORG_ID")
    private String parentOrgId;

    /**
     * 教师简介
     */
    @Column(name = "INTRODUCE")
    private String introduce;

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
     * 获取性别
     *
     * @return SEX - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取出生日期
     *
     * @return BIRTHDAY - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     * 获取系（科室）
     *
     * @return DEPARTMENT - 系（科室）
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置系（科室）
     *
     * @param department 系（科室）
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取联系电话
     *
     * @return TELNO - 联系电话
     */
    public String getTelno() {
        return telno;
    }

    /**
     * 设置联系电话
     *
     * @param telno 联系电话
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * 获取E_mail地址
     *
     * @return EMAIL - E_mail地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置E_mail地址
     *
     * @param email E_mail地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系地址
     *
     * @return ADDRESS - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取教职工类别
     *
     * @return CATEGORY - 教职工类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置教职工类别
     *
     * @param category 教职工类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取学历
     *
     * @return EDUCATION - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取学位
     *
     * @return DEGREE - 学位
     */
    public String getDegree() {
        return degree;
    }

    /**
     * 设置学位
     *
     * @param degree 学位
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * 获取职务
     *
     * @return DUTY - 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置职务
     *
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取职称
     *
     * @return ACDEMICTITLE - 职称
     */
    public String getAcdemictitle() {
        return acdemictitle;
    }

    /**
     * 设置职称
     *
     * @param acdemictitle 职称
     */
    public void setAcdemictitle(String acdemictitle) {
        this.acdemictitle = acdemictitle;
    }

    /**
     * 获取可否监考：T：可以；F：不可以
     *
     * @return INVIGILATORFLAG - 可否监考：T：可以；F：不可以
     */
    public String getInvigilatorflag() {
        return invigilatorflag;
    }

    /**
     * 设置可否监考：T：可以；F：不可以
     *
     * @param invigilatorflag 可否监考：T：可以；F：不可以
     */
    public void setInvigilatorflag(String invigilatorflag) {
        this.invigilatorflag = invigilatorflag;
    }

    /**
     * 获取研究方向
     *
     * @return RESEARCHDIRECTION - 研究方向
     */
    public String getResearchdirection() {
        return researchdirection;
    }

    /**
     * 设置研究方向
     *
     * @param researchdirection 研究方向
     */
    public void setResearchdirection(String researchdirection) {
        this.researchdirection = researchdirection;
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
     * 获取毕业院校
     *
     * @return GRADUATE - 毕业院校
     */
    public String getGraduate() {
        return graduate;
    }

    /**
     * 设置毕业院校
     *
     * @param graduate 毕业院校
     */
    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    /**
     * 获取教师资格标志：Y:有；N：无
     *
     * @return QUALIFICATIONFLAG - 教师资格标志：Y:有；N：无
     */
    public String getQualificationflag() {
        return qualificationflag;
    }

    /**
     * 设置教师资格标志：Y:有；N：无
     *
     * @param qualificationflag 教师资格标志：Y:有；N：无
     */
    public void setQualificationflag(String qualificationflag) {
        this.qualificationflag = qualificationflag;
    }

    /**
     * 获取在职状态：Y:在职；N：离职
     *
     * @return JOBSTATUS - 在职状态：Y:在职；N：离职
     */
    public String getJobstatus() {
        return jobstatus;
    }

    /**
     * 设置在职状态：Y:在职；N：离职
     *
     * @param jobstatus 在职状态：Y:在职；N：离职
     */
    public void setJobstatus(String jobstatus) {
        this.jobstatus = jobstatus;
    }

    /**
     * 获取教师级别
     *
     * @return TEACHER_LEVEL - 教师级别
     */
    public String getTeacherLevel() {
        return teacherLevel;
    }

    /**
     * 设置教师级别
     *
     * @param teacherLevel 教师级别
     */
    public void setTeacherLevel(String teacherLevel) {
        this.teacherLevel = teacherLevel;
    }

    /**
     * 获取是否实验室人员：Y：是；N：否
     *
     * @return ISLAB - 是否实验室人员：Y：是；N：否
     */
    public String getIslab() {
        return islab;
    }

    /**
     * 设置是否实验室人员：Y：是；N：否
     *
     * @param islab 是否实验室人员：Y：是；N：否
     */
    public void setIslab(String islab) {
        this.islab = islab;
    }

    /**
     * 获取是否外聘
     *
     * @return ISOUTHIRE - 是否外聘
     */
    public String getIsouthire() {
        return isouthire;
    }

    /**
     * 设置是否外聘
     *
     * @param isouthire 是否外聘
     */
    public void setIsouthire(String isouthire) {
        this.isouthire = isouthire;
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
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取教师简介
     *
     * @return INTRODUCE - 教师简介
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置教师简介
     *
     * @param introduce 教师简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}