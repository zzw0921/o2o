package cn.azzhu.myo2o.vo;

import cn.azzhu.myo2o.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-5 14:09
 */

@Data
public class ProductVo extends Product {

    private String productName;
    private String startPrice;
    private String endPrice;
    private String startTime;
    private String endTime;

    private List<Long> shopIds;
}