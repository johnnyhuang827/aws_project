package com.example.mapper;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface ProductMapper extends Mapper<Product>{




}
