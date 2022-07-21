package com.lhl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhl.dao.CourseDao;
import com.lhl.domain.Course;
import com.lhl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author long
 */
@Service
public class CourseImpl extends ServiceImpl<CourseDao,Course> implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> selectPageByName(String courseName, int currentPage, int pageSize){
            return courseDao.getPageByName(courseName, currentPage, pageSize);
    }

    @Override
    public IPage<Course> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        courseDao.selectPage(page,null);
        return page;
    }

}
