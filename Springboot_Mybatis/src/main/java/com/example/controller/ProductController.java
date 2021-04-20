package com.example.controller;


import com.example.ajax.AjaxResult;
import com.example.entity.Product;
import com.example.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @GetMapping("/{id}")
    public Product getInfo(@PathVariable Long id)
    {
        return productService.selectProductById(id);
    }


    @PostMapping
    public AjaxResult add(@Validated @RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }
    

    @DeleteMapping("/{id}")
    public AjaxResult remove( @PathVariable long id)
    {
        return toAjax(productService.deleteProductById(id));
    }

    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    @GetMapping("/queryById/{id}")
    public List<Product> queryById(@PathVariable Long id)
    {
        return productService.queryById(id);
    }

    @GetMapping("/queryByName/{name}")
    public List<Product> queryByName(@PathVariable String name)
    {
        return productService.queryByName(name);
    }

    @GetMapping("/queryByInfo/{info}")
    public List<Product> queryByInfo(@PathVariable String info)
    {
        return productService.queryByInfo(info);
    }

    @RequestMapping("/queryAll")
    public List<Product> queryAll(){
        return productService.queryAll();
    }

    @GetMapping("/queryLessThanNum/{num}")
    public List<Product> queryLessThanNum(@PathVariable Long num)
    {
        return productService.queryLessThanNum(num);
    }
}


