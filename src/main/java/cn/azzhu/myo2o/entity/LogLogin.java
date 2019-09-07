package cn.azzhu.myo2o.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.Data;

import java.util.Date;

@Data
public class LogLogin{

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String loginname;

    private String loginip;

    private Date logintime;

}