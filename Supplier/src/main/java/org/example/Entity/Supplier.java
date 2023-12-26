package org.example.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "supplier")
public class Supplier {
    private Long id;
    private String name;

    // 注意: MyBatis 需要一个无参构造函数
    public Supplier() {}

    public Supplier(String name) {
        this.name = name;
    }
}
