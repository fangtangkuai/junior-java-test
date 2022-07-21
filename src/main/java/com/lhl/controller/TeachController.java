package com.lhl.controller;

import com.lhl.controller.utils.R;
import com.lhl.domain.Course;
import com.lhl.domain.Teach;
import com.lhl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author long
 */
@RestController
@RequestMapping("/teachs")
public class TeachController {
    @Autowired
    private TeachService teachService;



    @PostMapping("{cid}/{sid}")
    public R save(@PathVariable Integer cid,@PathVariable Integer sid) {
        return new R(teachService.saveByTwo(cid,sid));
    }
    @GetMapping("{sid}")
    public R getById(@PathVariable Integer sid) {
        return new R(true,teachService.selectByStudent(sid));
    }

}
