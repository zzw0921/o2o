package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.PersonInfo;
import org.springframework.stereotype.Repository;

/**
 * @author:azzw
 * @date 2019-9-4 9:10
 */
@Repository
public interface PersonInfoService {

    PersonInfo getPersonInfo(PersonInfo personInfo);
}
