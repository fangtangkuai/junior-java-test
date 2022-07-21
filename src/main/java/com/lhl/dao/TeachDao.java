package com.lhl.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhl.domain.Teach;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * @author long
 */
@Mapper
@TableName("teach")
public interface TeachDao extends BaseMapper<Teach> {

    @Select("select s.sid,s.stud_name,s.sex,s.grade,c.cid,c.course_name,c.credit from student s , course c , teach t where t.sid=${sid} and t.sid=s.sid and t.cid=c.cid")
    List<Teach> getByStudentId(Integer sid);

    @Select("select s.sid,s.stud_name,s.sex,s.grade,c.cid,c.course_name,c.credit from student s , course c , teach t where t.cid=${cid} and t.sid=s.sid and t.cid=c.cid")
    List<Teach> getByCourseId(Integer cid);

    @Insert("insert into teach(cid,sid) value(${cid},${sid})")
    int saveByTwoId(@Param("cid")Integer cid, @Param("sid")Integer sid);


    @Delete("delete from teach where sid=${sid}")
    int deleteByStudentId(Integer sid);

    @Delete("delete from teach where cid=${cid}")
    int deleteByCourseId(Integer cid);

}
