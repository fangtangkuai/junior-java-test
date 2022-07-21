package com.lhl.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhl.dao.CourseDao;
import com.lhl.dao.TeachDao;
import com.lhl.domain.Course;
import com.lhl.domain.Teach;
import com.lhl.service.CourseService;
import com.lhl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author long
 */
@Service
public class TeachImpl extends ServiceImpl<TeachDao, Teach> implements TeachService {
    @Autowired
    private TeachDao teachDao;


    @Override
    public List<Teach> selectByStudent(Integer sid) {
        return teachDao.getByStudentId(sid);
    }

    @Override
    public List<Teach> selectByCourse(Integer cid) {
        return teachDao.getByCourseId(cid);
    }

    @Override
    public Boolean saveByTwo(Integer cid, Integer sid) {
        return teachDao.saveByTwoId(cid,sid)>0;
    }

    @Override
    public Boolean deleteByStudent(Integer sid) {
        return teachDao.deleteByStudentId(sid)>0;
    }

    @Override
    public Boolean deleteByCourse(Integer cid) {
        return teachDao.deleteByCourseId(cid)>0;
    }
}
