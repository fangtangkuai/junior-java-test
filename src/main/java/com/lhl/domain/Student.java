package com.lhl.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * @author long
 */
@Data
public class Student {
    @TableId
    private Integer sid;
    @TableField("stud_name")
    private String studName;
    private Integer sex;
    private Integer grade;
}
