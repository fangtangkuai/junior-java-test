package com.lhl.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * @author long
 */
@Data
public class Course {
    @TableId
    private Integer cid;
    @TableField("course_name")
    private String courseName;
    private Integer credit;
}
