package com.Mrs.Wang.project.DTO;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于学生查询可选课程的条件对象
 * @author: hezijian6338
 * @create: 2018-12-28 11:29
 **/

public class CourseInfoStuCondition {
    private String aca;
    private String courseType;
    private String term;
    private String credit;
    private String classInfo;

    public void setAca(String aca) {
        this.aca = aca;
    }

    public String getAca() {
        return aca;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCredit() {
        return credit;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }
}
