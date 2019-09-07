package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.LogLogin;
import cn.azzhu.myo2o.mapper.LogLoginMapper;
import cn.azzhu.myo2o.service.LogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:azzw
 * @date 2019-9-4 10:22
 */

@Service
public class LogLoginServiceImpl implements LogLoginService {


    @Autowired
    private LogLoginMapper logLoginMapper;

    @Override
    public int addLogLogin(LogLogin logLogin) {

       return logLoginMapper.insert(logLogin);
    }
}