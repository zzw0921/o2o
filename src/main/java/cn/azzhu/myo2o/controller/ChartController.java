package cn.azzhu.myo2o.controller;

import cn.azzhu.myo2o.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:azzw
 * @date 2019-9-6 13:49
 */

@Controller
@RequestMapping("shop/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;


    @GetMapping("/top5.html")
    public String toTop5() {

        return "chart/top5";
    }


    @GetMapping("top5Product")
    @ResponseBody
    public Object getTop5Product(@RequestParam(value = "month", required = false) String month,
                                 @RequestParam(value = "startTime", required = false) String startTime,
                                 @RequestParam(value = "endTime", required = false) String endTime) {
        HashMap<String, String> map = new HashMap<>();
        map.put("month", month);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        List<Map<String, Object>> top5Product = chartService.getTop5Product(map);
        return top5Product;
    }

    @GetMapping("/order.html")
    public String toOrder() {

        return "chart/order";
    }


    @GetMapping("orderStatus")
    @ResponseBody
    public Object getOrderStatus(@RequestParam(value = "month", required = false) String month,
                                 @RequestParam(value = "startTime", required = false) String startTime,
                                 @RequestParam(value = "endTime", required = false) String endTime) {
        HashMap<String, String> map = new HashMap<>();
        map.put("month", month);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        Map<String, Integer> orderStatus = chartService.getOrderStatus(map);
        return orderStatus;
    }


    @GetMapping("/money.html")
    public String toMoney() {

        return "chart/money";
    }


    @GetMapping("money")
    @ResponseBody
    public Object getMoney(@RequestParam(value = "month", required = false) String month,
                           @RequestParam(value = "startTime", required = false) String startTime,
                           @RequestParam(value = "endTime", required = false) String endTime) {
        HashMap<String, String> map = new HashMap<>();
        map.put("month", month);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        List<Map<String, Object>> money = chartService.getMoney(map);
        return money;
    }
}