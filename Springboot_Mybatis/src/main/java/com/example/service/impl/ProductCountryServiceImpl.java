package com.example.service.impl;

import com.example.entity.Product;
import com.example.mapper.CountryMapper;
import com.example.mapper.ProductMapper;
import com.example.service.ProductCountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProductCountryServiceImpl implements ProductCountryService {


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CountryMapper countryMapper;


    @Override
    public int insertByCountry(Long productId, Long countryId) {
        return 0;
    }

    @Override
    public int deleteByCountry(Long productId, Long countryId) {
        return 0;
    }

    @Override
    public int updateByCountry(Long productId, Long countryId) {
        return 0;
    }
}
