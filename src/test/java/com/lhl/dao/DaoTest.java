package com.lhl.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhl.domain.Course;
import com.lhl.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class DaoTest {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeachDao teachDao;

//    @Test
//    void testCourseGetPageByName() {
//        courseDao.getPageByName("导论");
//    }

    @Test
    void testCourseGetPageByName() {
        courseDao.getPageByName("",2,5);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(3, 5);
        courseDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

    @Test
    void testCourseUpdate() {
        Course course = new Course();
        course.setCid(14);
        course.setCourseName("测试数据321");
        course.setCredit(3);

        courseDao.updateById(course);
    }

    @Test
    void testCourseDelete() {
        courseDao.deleteById(14);
    }

    @Test
    void testCourseSave() {
        Course  course = new Course();
        course.setCid(22);
        course.setCourseName("测试数据323231");
        course.setCredit(4);
        courseDao.insert(course);
    }

    @Test
    void testTeachStudentGet(){
        teachDao.getByStudentId(2);
    }

    @Test
    void testTeachCourseGet(){
        teachDao.getByCourseId(2);
    }

    @Test
    void testTeachUpdate(){
        teachDao.saveByTwoId(2,2);
    }

    @Test
    void testTeachDeleteByStudent(){
        teachDao.deleteByStudentId(2);
    }

    @Test
    void testTeachDeleteByCourse(){
        teachDao.deleteByCourseId(2);
    }

    @Test
    void studentGetById(){
        studentDao.selectById(2);
    }

    @Test
    void studentSave(){
        Student student=new Student();
        student.setSid(13);
        student.setSex(0);
        student.setStudName("伊尔易");
        student.setGrade(2);
        studentDao.insert(student);
    }

    @Test
    void studentUpdate(){
        Student student=new Student();
        student.setSid(13);
        student.setSex(1);
        student.setStudName("伊尔厄");
        student.setGrade(1);
        studentDao.updateById(student);
    }

    @Test
    void studentDelete(){
        studentDao.deleteById(13);
    }

}
