package com.lhl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhl.domain.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author long
 */
public interface CourseService extends IService<Course> {
    List<Course> selectPageByName(String courseName, int currentPage, int pageSize);
    IPage<Course> getPage(int currentPage, int pageSize);

}
