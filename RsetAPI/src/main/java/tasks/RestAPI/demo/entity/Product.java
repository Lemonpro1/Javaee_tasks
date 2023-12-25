package tasks.RestAPI.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "product")
public class Product {
    private Long id;
    private String name;
    private double price;


    // 注意: MyBatis 需要一个无参构造函数
    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
