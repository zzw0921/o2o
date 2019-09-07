package cn.azzhu.myo2o.service.impl;

import cn.azzhu.myo2o.entity.ProductCategory;
import cn.azzhu.myo2o.mapper.ProductCategoryMapper;
import cn.azzhu.myo2o.service.ProductCategoryService;
import cn.azzhu.myo2o.utils.DataGridView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-5 10:13
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataGridView getDataGridView(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<ProductCategory> products = productCategoryMapper.selectList(null);
        PageInfo<ProductCategory> pageInfo = new PageInfo<>(products);
        DataGridView<ProductCategory> dataGridView = new DataGridView<>();
        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(pageInfo.getList());
        return dataGridView;
    }
}
