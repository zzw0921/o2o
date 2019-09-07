package cn.azzhu.myo2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author:azzw
 * @date 2019-9-5 10:37
 */
@Data
public class ProductCategory {


    private Integer productcategoryId;

    private String productcategoryName;

    private String productcategoryDesc;

    private Integer priority;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lasteditTime;

    private Integer shopId;


}
