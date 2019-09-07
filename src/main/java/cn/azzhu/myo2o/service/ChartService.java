package cn.azzhu.myo2o.service;

import java.util.List;
import java.util.Map;

/**
 * @author:azzw
 * @date 2019-9-6 13:43
 */
public interface ChartService {

    List<Map<String,Object>> getTop5Product(Map<String,String> map);

    Map<String,Integer> getOrderStatus(Map<String, String> map);

    List<Map<String,Object>> getMoney(Map<String,String> map);

}
