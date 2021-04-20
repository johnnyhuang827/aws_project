package com.example.service;

import com.example.entity.Product;


import java.util.List;


public interface ProductService {

    int insertProduct(Product product);

    int deleteProductById(Long id);

    int updateProduct(Product product);

    Product selectProductById(Long id);

    List<Product> queryById(Long id);

    List<Product> queryByName(String name);

    List<Product> queryByInfo(String info);

    List<Product> queryLessThanNum(Long num);

    List<Product> queryAll();
}
