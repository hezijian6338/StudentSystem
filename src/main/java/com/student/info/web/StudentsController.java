package com.student.info.web;

import com.student.info.DTO.CoursefInfoDTO;
import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.model.CourseInfo;
import com.student.info.model.CourseInfoStudent;
import com.student.info.model.Students;
import com.student.info.model.TeacherInfo;
import com.student.info.service.StudentsService;
import com.student.info.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * Created by Dragonsking309 on 2018/11/19.
 */
@RestController
@RequestMapping("/students")
public class StudentsController {
    @Resource
    private StudentsService studentsService;

    @Resource
    private UserService userService;

    @PostMapping
    public Result add(@RequestBody Students students) {
        studentsService.save(students);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Students students) {
        studentsService.update(students);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Students students = studentsService.findById(id);
        return ResultGenerator.genSuccessResult(students);
    }

    @GetMapping("/{fieldfieldName}/{value}")
    public Result searchBy(@PathVariable String fieldfieldName, @PathVariable String value) {
        Students students = studentsService.findBy(fieldfieldName, value);
        if (isEmpty(students)) {
            students = new Students();
        }
        return ResultGenerator.genSuccessResult(students);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Students> list = studentsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list/user")
    public Result listOfUser() {
        List<Students> students = studentsService.findStudentsByUser(userService.findAll());
        return ResultGenerator.genSuccessResult(students);
    }


    /**
     * TODO: 根据学生基本信息返回可选的课程信息
     *
     * @param studentno
     * @return Result
     * @throws
     * @author hezijian6338
     * @date 2019/3/13 15:32
     **/

    @GetMapping("/{studentno}/courseInfos")
    public Result findCourseWithStudent(@PathVariable String studentno) {
        Students student = studentsService.findByStudentno(studentno);
        List<CourseInfo> list = studentsService.findCourseWithStudent(student);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * TODO: 根据返回的学号和选择课程的代码数据来保存选课
     * @author hezijian6338
     * @date 2019/3/13 15:34
     * @param studentno
     * @param courses
     * @return Result
     * @throws
     **/

    @PostMapping("/{studentno}/courses")
    public Result saveSelectedCourses(@PathVariable String studentno, @RequestBody CoursefInfoDTO courses) {
        studentsService.saveSelectedCourses(studentno, courses.getCourseids());
        return ResultGenerator.genSuccessResult();
    }

    /**
     * TODO: 根据学号返回已选的课程
     * @author hezijian6338
     * @date 2019/3/13 16:42
     * @param studentno
     * @return Result
     * @throws
     **/

    @GetMapping("/{studentno}/courses")
    public Result findSelectedCoursesByStudentno(@PathVariable String studentno) {
        List<CourseInfoStudent> list = studentsService.findSelectedCoursesByStudentno(studentno);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * TODO: 学生选择导学老师
     * @author hezijian6338
     * @date 2019/3/14 9:55
     * @param studentno
     * @param teacherno
     * @return Result
     * @throws
     **/

    @PostMapping("/{studentno}/guidTeacher/{teacherno}")
    public Result saveSelectGuidTeacher(@PathVariable String studentno, @PathVariable String teacherno) {
        studentsService.saveSelectGuidTeacher(studentno, teacherno);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * TODO: 学生查看已选的导学老师
     * @author hezijian6338
     * @date 2019/3/14 10:04
     * @param studentno
     * @return Result
     * @throws
     **/

    @GetMapping("/{studentno}/guidTeacher")
    public Result findSelectedGuidTeacherByStudentno(@PathVariable String studentno) {
        TeacherInfo teacherInfo = studentsService.findSelectedGuidTeacherByStudentno(studentno);
        return ResultGenerator.genSuccessResult(teacherInfo);
    }

    /**
     * TODO: 保存当前学生的资料
     * @author hezijian6338
     * @date 2019/3/13 15:34
     * @param Students
     * @param courses
     * @return Result
     * @throws
     **/

    @PostMapping("/updateStu")
    public Result saveSelectedCourses(@RequestBody Students student) {
        studentsService.update(student);
        return ResultGenerator.genSuccessResult();
    }

}
