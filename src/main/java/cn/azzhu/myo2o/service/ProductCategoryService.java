package cn.azzhu.myo2o.service;


import cn.azzhu.myo2o.utils.DataGridView;
/**
 * @author:azzw
 * @date 2019-9-5 10:12
 */

public interface ProductCategoryService {

    DataGridView getDataGridView(Integer pageNum, Integer pageSize);
}
