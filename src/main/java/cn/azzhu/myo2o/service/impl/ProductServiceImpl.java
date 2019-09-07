package cn.azzhu.myo2o.service.impl;
import cn.azzhu.myo2o.entity.Product;
import cn.azzhu.myo2o.mapper.ProductMapper;
import cn.azzhu.myo2o.service.ProductService;
import cn.azzhu.myo2o.vo.ProductVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;



    @Override
    public PageInfo<Product> getPage(Integer pageNum, Integer pageSize, ProductVo productVo) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        if(productVo.getProductName() != null && !"".equals(productVo.getProductName())) {
            queryWrapper.like("product_name", productVo.getProductName());
        }

        if(productVo.getStartTime() != null &&!"".equals(productVo.getStartTime()) &&
                productVo.getEndTime() != null  && !"".equals(productVo.getEndTime())) {
            queryWrapper.between("create_time", productVo.getStartTime(), productVo.getEndTime());
        }

        if(productVo.getStartPrice() != null && !"".equals(productVo.getStartPrice()) &&
                productVo.getStartPrice() != null && !"".equals(productVo.getEndPrice())) {
            queryWrapper.between("promotion_price", productVo.getStartPrice(), productVo.getEndPrice());
        }


        if(productVo.getEnableStatus() != null && productVo.getEnableStatus() == 3) {
            queryWrapper.in("enable_status",0,1);
        }


        if(productVo.getEnableStatus() != null && productVo.getEnableStatus() != 3) {
            queryWrapper.eq("enable_status", productVo.getEnableStatus());
        }

        queryWrapper.in("enable_status",0,1);


        queryWrapper.in("shop_id", productVo.getShopIds());

        List<Product> products = productMapper.selectList(queryWrapper);
        return new PageInfo<>(products);
    }

    @Override
    public void deleteProductById(Product product) {

        product.setEnableStatus(2);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void deleteProductByIds(String[] ids) {
        Product product = new Product();
        product.setEnableStatus(2);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("product_id",ids);
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void down(Product product) {
        product.setEnableStatus(1);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void up(Product product) {
        product.setEnableStatus(0);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateById(product);
    }


}
