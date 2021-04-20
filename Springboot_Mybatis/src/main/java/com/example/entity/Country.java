package com.example.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Table(name = "country")
public class Country {


    //使用lombok 简化实体类
    @NotNull(message = "id不能为空")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer countryId;

    private String countryName;

    private Integer countryTax;



}
