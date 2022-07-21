package com.lhl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhl.domain.Teach;

import java.util.List;

/**
 * @author long
 */
public interface TeachService extends IService<Teach> {
    List<Teach> selectByStudent(Integer sid);
    List<Teach> selectByCourse(Integer cid);
    Boolean saveByTwo(Integer cid,Integer sid);
    Boolean deleteByStudent(Integer sid);
    Boolean deleteByCourse(Integer cid);

}
