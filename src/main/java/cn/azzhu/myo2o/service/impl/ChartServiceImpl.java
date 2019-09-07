package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.mapper.ChartMapper;
import cn.azzhu.myo2o.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:azzw
 * @date 2019-9-6 13:43
 */

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartMapper chartMapper;

    @Override
    public List<Map<String,Object>> getTop5Product(Map<String,String> map){

        return chartMapper.getTop5Product(map);
    }

    @Override
    public Map<String, Integer> getOrderStatus(Map<String,String> map) {
        return chartMapper.getOrderStatus(map);


    }

    @Override
    public List<Map<String, Object>> getMoney(Map<String, String> map) {
        return chartMapper.getMoney(map);
    }
}
