package com.example.service;


import com.example.entity.Product;
import com.example.entity.Country;


import java.util.List;

public interface ProductCountryService {


    int insertByCountry(Long productId, Long countryId);

    int deleteByCountry(Long productId, Long countryId);

    int updateByCountry(Long productId, Long countryId);
}
