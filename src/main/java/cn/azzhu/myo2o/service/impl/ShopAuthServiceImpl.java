package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.LocalAuth;
import cn.azzhu.myo2o.entity.ShopAuthMap;
import cn.azzhu.myo2o.mapper.ShopAuthMapMapper;
import cn.azzhu.myo2o.service.ShopAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-5 14:20
 */

@Service
public class ShopAuthServiceImpl implements ShopAuthService {
    @Autowired
    private ShopAuthMapMapper shopAuthMapMapper;

    @Override
    public List<ShopAuthMap> getShopsByAuthId(LocalAuth auth) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",auth.getUserId());
        return shopAuthMapMapper.selectList(queryWrapper);
    }
}
