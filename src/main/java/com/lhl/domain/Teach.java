package com.lhl.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @author long
 */
@Data
public class Teach {

    private Integer sid;
    @TableField("stud_name")
    private String studName;
    private Integer sex;
    private Integer grade;

    private Integer cid;
    @TableField("course_name")
    private String courseName;
    private Integer credit;
}
