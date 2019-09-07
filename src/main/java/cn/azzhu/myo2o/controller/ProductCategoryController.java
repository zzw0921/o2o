package cn.azzhu.myo2o.controller;

import cn.azzhu.myo2o.entity.ProductCategory;
import cn.azzhu.myo2o.service.ProductCategoryService;
import cn.azzhu.myo2o.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:azzw
 * @date 2019-9-5 10:22
 */

@Controller
@RequestMapping("shop/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("list.html")
    public String toList(){
        return "category/list";
    }


    @GetMapping("list")
    @ResponseBody
    public DataGridView list(ProductCategory productCategory,
                             @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                             @RequestParam(value = "limit",required = false,defaultValue = "5")Integer limit){

        return productCategoryService.getDataGridView(page,limit);
    }
}
