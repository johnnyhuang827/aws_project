package com.example.service;


import com.example.entity.Order;
import com.example.entity.Product;


import java.util.List;
public interface OrderService {

    int insertOrder(Long productId, Integer countryId, Long customerId, Integer num) throws Exception;


    List<Order> queryByCustomerId(Long customerId);

    List<Order> queryByProductId(Long productId);

    List<Order> queryGreaterThanPrice(Double price);
}
