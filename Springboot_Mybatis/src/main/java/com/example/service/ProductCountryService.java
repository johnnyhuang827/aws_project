package com.example.service;


import com.example.entity.Product;
import com.example.entity.Country;
import com.example.entity.ProductCountry;


import java.util.List;

public interface ProductCountryService {


    int insertByCountry(List<ProductCountry> list) throws Exception;

    int deleteByCountry(List<ProductCountry> list);

    int updateByCountry(List<ProductCountry> list);
}
