package cn.azzhu.myo2o.service.impl;


import cn.azzhu.myo2o.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:azzw
 * @date 2019-9-4 20:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void getDataGridView(){
        System.out.println(productCategoryService.getDataGridView(1, 5));
    }

}
