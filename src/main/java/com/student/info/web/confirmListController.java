package com.student.info.web;

import com.student.info.core.Result;
import com.student.info.core.ResultGenerator;
import com.student.info.model.LearningguidStudentslist;
import com.student.info.model.Students;
import com.student.info.model.TeacherInfo;
import com.student.info.model.confirmList;
import com.student.info.service.LearningguidStudentslistService;
import com.student.info.service.StudentsService;
import com.student.info.service.TeacherInfoService;
import com.student.info.service.confirmListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.info.utils.DATEUtils;
import com.student.info.utils.JWTUtils;
import com.student.info.utils.UUIDUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by Dragonsking309 on 2020/04/11.
*/
@RestController
@RequestMapping("/confirm/list")
public class confirmListController {
    @Resource
    private confirmListService confirmListService;

    @Resource
    private StudentsService studentsService;

    @Resource
    private LearningguidStudentslistService learningguidStudentslistService;

    @Resource
    private TeacherInfoService teacherInfoService;

    @PostMapping
    public Result add(@RequestBody confirmList confirmList) {
        confirmListService.save(confirmList);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        confirmListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody confirmList confirmList) {
        confirmListService.update(confirmList);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        confirmList confirmList = confirmListService.findById(id);
        return ResultGenerator.genSuccessResult(confirmList);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<confirmList> list = confirmListService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/unconfirm/{employno}/{stuNum}")
    public Result RequestGuideTeacher(@PathVariable String employno, @PathVariable String stuNum) {
//        learningguidStudentslistService.studentReEmployno(id, employno);
        Students student = studentsService.findByStudentno(stuNum);
//        System.out.println(student.getStuId() + student.getStuname() + student.getStudentno());

        //Set some necessary data in manual
        confirmList confirmList1 = new confirmList();
        confirmList1.setAcademicyear("2016-2017");
        confirmList1.setStatus("0");
        confirmList1.setStudentno(stuNum);
        confirmList1.setTerm("1");
        confirmList1.setTeacherno(employno);
        confirmList1.setId(UUIDUtils.getUUID());

        confirmListService.save(confirmList1);

        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/disStu/{employNo}")
    public Result disStu(@PathVariable String employNo) {
        List<confirmList> list = confirmListService.findAll();
        List<Students> stuList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).getTeacherno().equals(employNo)){
                list.remove(i);
                i = i -1;
            }else{
                if(list.get(i).getStatus().equals("0")) {
                    stuList.add(studentsService.findByStudentno(list.get(i).getStudentno()));
                }
            }
        }
//        System.out.println(stuList.get(0).getStuname());
        return ResultGenerator.genSuccessResult(stuList);
    }


    @PostMapping("/confStu/{stuNo}/{teacherEmployno}")
    public Result confirm(@PathVariable String stuNo, @PathVariable String teacherEmployno) {

        TeacherInfo teacherInfo = teacherInfoService.findByTeacherno(teacherEmployno);
        Students students = studentsService.findByStudentno(stuNo);
        confirmList example = new confirmList();

        List<confirmList> lists = confirmListService.findAll();
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).getStudentno().equals(stuNo)){
                if(lists.get(i).getTeacherno().equals(teacherEmployno)){
                    example = lists.get(i);
                }
                lists.get(i).setStatus("1");
                confirmListService.update(lists.get(i));
            }else{
                lists.remove(i);
                i = i - 1;
            }
        }

        LearningguidStudentslist learningguidStudentslist = new LearningguidStudentslist();
        learningguidStudentslist.setId(UUIDUtils.getUUID());
        learningguidStudentslist.setTeacherno(teacherInfo.getEmployNo());
        learningguidStudentslist.setTeachername(teacherInfo.getEmployName());
        learningguidStudentslist.setStuId(students.getStuId());
        learningguidStudentslist.setClassname(students.getClassname());
        learningguidStudentslist.setStuname(students.getStuname());
        learningguidStudentslist.setAcademicyear(example.getAcademicyear());
        learningguidStudentslist.setCreateTime(DATEUtils.getDATE());
        learningguidStudentslist.setStudentno(students.getStudentno());
        learningguidStudentslist.setTerm(example.getTerm());

        learningguidStudentslistService.save(learningguidStudentslist);

        System.out.println("Here？？？？");

        return ResultGenerator.genSuccessResult();
    }

}
