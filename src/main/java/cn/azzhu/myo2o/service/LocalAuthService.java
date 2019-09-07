package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.LocalAuth;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-3 11:16
 */

public interface LocalAuthService {

    LocalAuth login(LocalAuth localAuth);

    LocalAuth getUserById(String username);

    void regist(LocalAuth localAuth);


}
