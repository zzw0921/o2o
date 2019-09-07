package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.Product;
import cn.azzhu.myo2o.utils.DataGridView;
import cn.azzhu.myo2o.vo.ProductVo;
import com.github.pagehelper.PageInfo;

/**
 * @author:azzw
 * @date 2019-9-4 19:59
 */
public interface ProductService {


    // DataGridView getDataGridView(Integer pageNum,Integer pageSize);
    PageInfo<Product> getPage(Integer pageNum, Integer pageSize, ProductVo productVo);


    /**
     * 商品删除
     * @param product
     */
    void deleteProductById(Product product);


    /**
     * 批量删除
     * @param ids
     */
    void deleteProductByIds(String[] ids);


    /**
     * 下架商品
     * @param product
     */
    void down(Product product);


    /**
     * 上架商品
     * @param product
     */
    void up(Product product);

    /**
     * 新增商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 修改商品
     * @param product
     */
    void updateProduct(Product product);
}



