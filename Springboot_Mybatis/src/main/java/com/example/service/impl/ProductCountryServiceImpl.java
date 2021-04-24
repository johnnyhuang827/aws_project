package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ProductCountry;
import com.example.mapper.CountryMapper;
import com.example.mapper.ProductCountryMapper;
import com.example.mapper.ProductMapper;
import com.example.service.ProductCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductCountryServiceImpl implements ProductCountryService {


    @Autowired
    private ProductCountryMapper productCountryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public int insertByCountry(List<ProductCountry> list) throws Exception {
        for(ProductCountry productCountry : list){
            if(!productMapper.existsWithPrimaryKey(productCountry.getProductId()) || !countryMapper.existsWithPrimaryKey(productCountry.getCountryId())){
                throw new Exception("country or product not exist");
            }else{
                productCountryMapper.insert(productCountry);
            }

        }
        return 1;
    }

    @Override
    public int deleteByCountry(List<ProductCountry> list) {
        for(ProductCountry productCountry : list){
            Example example = new Example(ProductCountry.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("productId", productCountry.getProductId());
            criteria.andEqualTo("countryId", productCountry.getCountryId());
            List<ProductCountry> l = productCountryMapper.selectByExample(example);
            for(ProductCountry productCountry1 : l){
                productCountryMapper.delete(productCountry1);
            }
        }
        return 1;
    }

    @Override
    public int updateByCountry(List<ProductCountry> list) {
        return 0;
    }
}
