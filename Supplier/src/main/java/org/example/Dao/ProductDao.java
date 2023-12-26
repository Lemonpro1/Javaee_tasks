package org.example.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.Entity.Product;

import java.util.List;

@Mapper
public interface ProductDao extends BaseMapper<Product> {
    @Select("SELECT * FROM product")
    List<Product> getAllProducts();

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product getProductById(Long id);

    @Insert("INSERT INTO product (name, price) VALUES (#{name}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createProduct(Product product);

    @Update("UPDATE product SET name = #{name}, price = #{price} WHERE id = #{id}")
    void updateProduct(Product product);

    @Delete("DELETE FROM product WHERE id = #{id}")
    void deleteProduct(Long id);
    @Select("SELECT p.*, s.* FROM product p LEFT JOIN product_supplier ps ON p.id = ps.product_id LEFT JOIN supplier s ON ps.supplier_id = s.id")
    List<Product> getProductsAndSuppliers();

}
