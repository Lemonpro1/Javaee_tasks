package org.example.Dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.Entity.Supplier;

import java.util.List;

@Mapper
public interface SupplierDao extends BaseMapper<Supplier> {

    @Select("SELECT * FROM supplier")
    List<Supplier> getAllSuppliers();

    @Select("SELECT * FROM supplier WHERE id = #{id}")
    Supplier getSupplierById(Long id);

    @Insert("INSERT INTO supplier (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createSupplier(Supplier supplier);

    @Update("UPDATE supplier SET name = #{name} WHERE id = #{id}")
    void updateSupplier(Supplier supplier);

    @Delete("DELETE FROM supplier WHERE id = #{id}")
    void deleteSupplier(Long id);

    @Select("SELECT s.*, p.* FROM supplier s LEFT JOIN product_supplier ps ON s.id = ps.supplier_id LEFT JOIN product p ON ps.product_id = p.id")
    List<Supplier> getSuppliersAndProducts();
}
