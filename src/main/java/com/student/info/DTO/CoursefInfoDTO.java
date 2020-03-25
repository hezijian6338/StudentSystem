package com.student.info.DTO;

import java.util.List;

/**
 * Created by Macbook on 2019/5/3.
 */
public class CoursefInfoDTO {
    private List<String> courseids;

    public void setCourseids(List<String> courseids) {
        this.courseids = courseids;
    }

    public List<String> getCourseids() {
        return courseids;
    }
}
