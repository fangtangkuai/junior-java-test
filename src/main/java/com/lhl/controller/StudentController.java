package com.lhl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhl.controller.utils.R;
import com.lhl.domain.Student;
import com.lhl.service.StudentService;
import com.lhl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author long
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeachService teachService;
    @GetMapping
    public R getAll() {
        return new R(true,studentService.list());
    }

    @PostMapping
    public R save(@RequestBody Student student) {
        return new R(studentService.save(student));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getById(@PathVariable int currentPage, @PathVariable int pageSize,@RequestBody Student student) {
        IPage page=studentService.getPage(student,currentPage,pageSize);
        if(currentPage>page.getPages())
        {
            page=studentService.getPage(student,(int)page.getPages(),pageSize);
        }
        return new R(true,page);
    }

    @PutMapping
    public R update(@RequestBody Student student) {
        return new R(studentService.updateById(student));
    }
    @DeleteMapping("{sid}")
    public R delete(@PathVariable Integer sid) {
        teachService.deleteByStudent(sid);
    return new R(studentService.removeById(sid));

    }

}
