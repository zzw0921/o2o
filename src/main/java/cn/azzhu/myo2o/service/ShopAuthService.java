package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.LocalAuth;
import cn.azzhu.myo2o.entity.ShopAuthMap;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-5 14:19
 */
public interface ShopAuthService {

    List<ShopAuthMap> getShopsByAuthId(LocalAuth auth);
}
