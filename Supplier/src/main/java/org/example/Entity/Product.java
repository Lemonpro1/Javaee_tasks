package org.example.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "product")
public class Product {
    private Long id;
    private String name;
    private double price;
    // 新增属性，表示商品的供货商列表
    @TableField(exist = false)
    private List<Supplier> suppliers;

    // 注意: MyBatis 需要一个无参构造函数
    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

