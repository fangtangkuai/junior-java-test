package com.lhl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhl.domain.Student;
/**
 * @author long
 */
public interface StudentService extends IService<Student> {
    IPage<Student> getPage(Student student,int currentPage, int pageSize);
}
