package com.lhl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhl.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeachService teachService;
    @Autowired
    private StudentService studentService;
    @Test
    void testSelectByName(){
        courseService.selectPageByName("导论",2,3);
    }


    @Test
    void testSelectStudent(){
        teachService.selectByStudent(1);
    }

    @Test
    void testSelectCourse(){
        teachService.selectByCourse(2);
    }

    @Test
    void testSaveTwo(){
        teachService.saveByTwo(2,3);
    }

    @Test
    void testDeleteStudent(){
        teachService.deleteByStudent(4);
    }

    @Test
    void testDeleteCourse(){
        teachService.deleteByCourse(7);
    }

    @Test
    void testGetPage() {

        Student student=new Student();
        student.setStudName("十");
        student.setSex(1);
        studentService.getPage(student,2,1);

    }
    @Test
    void testSaveStudent(){
        Student student=new Student();
        student.setSid(17);
        student.setSex(1);
        student.setStudName("伊尔厄");
        student.setGrade(1);
        studentService.save(student);
    }


}
