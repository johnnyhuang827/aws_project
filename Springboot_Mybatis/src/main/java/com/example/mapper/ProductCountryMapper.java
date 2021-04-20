
package com.example.mapper;
import com.example.entity.ProductCountry;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface ProductCountryMapper extends Mapper<ProductCountry> {


//    @Insert("INSERT INTO product_country product_id, country_id VALUES #{productId}, #{countryId}")
//    int insertByCountry(Long productId, Long countryId);
//
//    @Delete("Delete FROM  product_country WHERE product_id = #{productId} and country_id = #{countryId}")
//    int deleteByCountry(Long productId, Long countryId);
//
//
//    int updateByCountry(Long productId, Long countryId);
}
