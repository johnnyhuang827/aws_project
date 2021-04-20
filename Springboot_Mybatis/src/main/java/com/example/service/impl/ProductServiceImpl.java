package com.example.service.impl;


import com.example.entity.Product;

import com.example.mapper.ProductMapper;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int insertProduct(Product product) {
        return productMapper.insertSelective(product);
    }


    @Override
    public int deleteProductById(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }
    
    @Override
    public Product selectProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> queryById(Long id) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productId", "%"+id+"%");
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> queryByName(String name) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productName", "%"+name+"%");
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> queryByInfo(String info) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productInfo", "%"+info+"%");
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> queryLessThanNum(Long num) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("productNum", num);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> queryAll() {
        return productMapper.selectAll();
    }
}
