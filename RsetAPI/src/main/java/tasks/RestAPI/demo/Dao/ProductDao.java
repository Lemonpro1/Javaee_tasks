package tasks.RestAPI.demo.Dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tasks.RestAPI.demo.entity.Product;
import org.apache.ibatis.annotations.*;

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
}
