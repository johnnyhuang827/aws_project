package com.example.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class OrderVo {


    @Id
    @KeySql(useGeneratedKeys = true)

    private Long productId;

    private Long customerId;

    private Integer num;

    private Integer countryId;

}
