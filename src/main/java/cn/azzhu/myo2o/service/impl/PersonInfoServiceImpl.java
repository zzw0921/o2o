package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.PersonInfo;
import cn.azzhu.myo2o.mapper.PersonInfoMapper;
import cn.azzhu.myo2o.service.PersonInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:azzw
 * @date 2019-9-4 9:11
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public PersonInfo getPersonInfo(PersonInfo personInfo) {

        QueryWrapper<PersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",personInfo.getUserId());
        return personInfoMapper.selectOne(queryWrapper);
    }
}
