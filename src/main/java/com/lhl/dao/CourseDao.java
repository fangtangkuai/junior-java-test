package com.lhl.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhl.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/**
 * @author long
 */
@Mapper
@TableName("course")
public interface CourseDao extends BaseMapper<Course> {

    @Select("select * from course where course_name like concat('%',#{courseName},'%') limit ${(currentPage-1)*pageSize},${pageSize}")
    List<Course> getPageByName(@Param("courseName")String courseName, @Param("currentPage")int currentPage,@Param("pageSize") int pageSize);

}
