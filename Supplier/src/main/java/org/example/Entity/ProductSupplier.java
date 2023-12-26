package org.example.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "product_supplier")
public class ProductSupplier {
    private Long productId;
    private Long supplierId;
}
