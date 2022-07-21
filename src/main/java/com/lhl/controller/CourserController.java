package com.lhl.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhl.controller.utils.R;
import com.lhl.domain.Course;
import com.lhl.service.CourseService;
import com.lhl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author long
 */
@RestController
@RequestMapping("/courses")
public class CourserController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeachService teachService;

    @GetMapping
    public R getAll() {
        return new R(true,courseService.list());
    }

    @PostMapping
    public R save(@RequestBody Course course) {
        return new R(courseService.save(course));
    }

    @DeleteMapping("{cid}")
    public R delete(@PathVariable Integer cid) {
        if(teachService.selectByCourse(cid)==null){
            return new R(courseService.removeById(cid));
        }
        else {
            return new R(false);
        }
    }

    @PutMapping
    public R update(@RequestBody Course course) {
        return new R(courseService.updateById(course));
    }

    @GetMapping("{currentPage}/{pageSize}/{courseName}")
    public R getByName(@PathVariable String courseName,@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true,courseService.selectPageByName(courseName, currentPage, pageSize));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        IPage page=courseService.getPage(currentPage,pageSize);
        if(currentPage>page.getPages())
        {
            page=courseService.getPage((int)page.getPages(),pageSize);
        }
        return new R(true,page);


    }
}
