package com.lhl.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhl.domain.Student;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author long
 */
@Mapper
@TableName("student")
public interface StudentDao extends BaseMapper<Student> {



}
