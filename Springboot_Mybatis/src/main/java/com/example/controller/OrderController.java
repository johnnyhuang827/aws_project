package com.example.controller;

import com.example.ajax.AjaxResult;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.service.OrderService;
import com.example.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }




    @PostMapping
    public AjaxResult add(@Validated @RequestBody OrderVo orderVo) throws Exception {
        Integer countryId = orderVo.getCountryId();
        Long productId = orderVo.getProductId();
        Long customerId = orderVo.getCustomerId();
        Integer num = orderVo.getNum();
        return toAjax(orderService.insertOrder(productId, countryId, customerId, num));
    }

    @GetMapping("/queryByCustomerId/{id}")
    public List<Order> queryById(@PathVariable Long id)
    {
        return orderService.queryByCustomerId(id);
    }

    @GetMapping("/queryByProductId/{id}")
    public List<Order> queryByName(@PathVariable Long id)
    {
        return orderService.queryByProductId(id);
    }


    @GetMapping("/queryGreaterThanPrice/{price}")
    public List<Order> queryByName(@PathVariable Double price)
    {
        return orderService.queryGreaterThanPrice(price);
    }


}

