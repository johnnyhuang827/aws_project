
package com.example.mapper;
import com.example.entity.ProductCountry;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface ProductCountryMapper extends Mapper<ProductCountry> {


}
