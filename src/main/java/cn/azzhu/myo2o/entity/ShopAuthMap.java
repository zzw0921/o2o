package cn.azzhu.myo2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ShopAuthMap {


    private Integer shopAuthId;

    private Integer employeeId;

    private Long shopId;

    private String name;

    private String title;

    private Integer titleFlag;

    private Date createTime;

    private Date lastEditTime;

    private Integer enableStatus;


}