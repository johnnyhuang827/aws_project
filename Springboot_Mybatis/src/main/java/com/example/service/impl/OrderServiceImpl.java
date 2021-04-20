package com.example.service.impl;

import com.example.entity.Country;
import com.example.entity.Order;
import com.example.entity.ProductCountry;
import com.example.entity.Product;
import com.example.mapper.*;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductCountryMapper productCountryMapper;

    @Override
    public int insertOrder(Long productId, Integer countryId, Long customerId, Integer num) throws Exception {
        //if country, product, customer exist
        if(!productMapper.existsWithPrimaryKey(productId) || !customerMapper.existsWithPrimaryKey(customerId) || !countryMapper.existsWithPrimaryKey(countryId)){
            throw new Exception("country, product or customer not exist");
        }
        else{

            Example example = new Example(ProductCountry.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("countryId", countryId);
            criteria.andEqualTo("productId", productId);
            //country not have product
            if(productCountryMapper.selectByExample(example).size() == 0){
                throw new Exception("This country doesn't have this products");
            }

            Product product = productMapper.selectByPrimaryKey(productId);

            //not enough num
            int numLeft =  product.getProductNum();
            if(numLeft < num){
                throw new Exception("not enough products left");
            }

            Double price = product.getProductPrice();
            Country country = countryMapper.selectByPrimaryKey(countryId);
            Integer tax = country.getCountryTax();
            Order order = new Order();
            order.setOrderId(null);
            order.setProductId(productId);
            order.setCountryId(countryId);
            order.setCustomerId(customerId);
            order.setNum(num);
            Double total = price * num;
            order.setPrice(total);
            Double totalTax = ((double) tax / (double) 100) * total;
            order.setTax(totalTax);


            product.setProductNum(numLeft - num);
            productMapper.updateByPrimaryKey(product);

            return orderMapper.insertSelective(order);

        }
    }


    @Override
    public List<Order> queryByCustomerId(Long customerId) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("customerId", customerId);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> queryByProductId(Long productId) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> queryGreaterThanPrice(Double price) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("price", price);
        return orderMapper.selectByExample(example);
    }
}
