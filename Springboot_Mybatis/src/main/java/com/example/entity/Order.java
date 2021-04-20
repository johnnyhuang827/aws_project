package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {


    //使用lombok 简化实体类

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long orderId;

    private Long productId;

    private Long customerId;

    private Integer num;

    private Double price;

    private Double tax;

    private Integer countryId;



}
