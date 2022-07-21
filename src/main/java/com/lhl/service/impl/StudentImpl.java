package com.lhl.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhl.dao.StudentDao;
import com.lhl.domain.Student;
import com.lhl.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author long
 */
@Service
public class StudentImpl extends ServiceImpl<StudentDao, Student> implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public IPage<Student> getPage(Student student, int currentPage, int pageSize) {
        IPage<Student> page=new Page(currentPage,pageSize);
        LambdaQueryWrapper<Student> lqw =new LambdaQueryWrapper<Student>();

        lqw.like(Strings.isNotEmpty(student.getStudName()),Student::getStudName,student.getStudName())
                .eq(student.getSex()!=null,Student::getSex,student.getSex())
                .eq(student.getGrade()!=null,Student::getGrade,student.getGrade());
        studentDao.selectPage(page,lqw);
        return page;
    }
}
