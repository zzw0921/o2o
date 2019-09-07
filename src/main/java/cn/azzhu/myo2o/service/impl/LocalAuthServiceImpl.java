package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.LocalAuth;
import cn.azzhu.myo2o.entity.PersonInfo;
import cn.azzhu.myo2o.enums.PersonInfoFlag;
import cn.azzhu.myo2o.mapper.LocalAuthMapper;
import cn.azzhu.myo2o.mapper.PersonInfoMapper;
import cn.azzhu.myo2o.service.LocalAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;


/**
 * @author:azzw
 * @date 2019-9-3 11:17
 */

@Service
@Transactional
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthMapper localAuthMapper;
    private PersonInfoMapper personInfoMapper;

    @Override
    public LocalAuth login(LocalAuth localAuth) {
        QueryWrapper<LocalAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",localAuth.getUserName());
        String password = localAuth.getPassword();
        String newpsd = DigestUtils.md5DigestAsHex(password.getBytes());
        queryWrapper.eq("password",newpsd);
        return localAuthMapper.selectOne(queryWrapper);
    }


    /**
     * 跳转到注册页面
     * @param username
     * @return
     */
    @Override
    public LocalAuth getUserById(String username) {
        QueryWrapper<LocalAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        return localAuthMapper.selectOne(queryWrapper);
    }


    /**
     * 注册
     * @param localAuth
     */
    @Override
    public void regist(LocalAuth localAuth) {

        //先插入person_info表
        PersonInfo personInfo = new PersonInfo();
        // 需要设置4个属性
        personInfo.setCustomerFlag(PersonInfoFlag.CUSTOMER.getCode());
        personInfo.setCustomerFlag(PersonInfoFlag.SHOPOEMPLOYEE.getCode());
        personInfo.setAdminFlag(1);
        personInfo.setCreateTime(new Date());
        //插入数据
        personInfoMapper.insert(personInfo);
        //TODO 难点：如何使用MP拿到刚插入的记录的主键值
        System.out.println("===================>"+personInfo.getUserId());
        //LocalAuth的相关信息
        localAuth.setUserId(personInfo.getUserId());
        localAuth.setCreateTime(new Date());
        localAuthMapper.insert(localAuth);
    }
}
