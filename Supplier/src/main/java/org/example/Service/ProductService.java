package org.example.Service;
import org.example.Entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getProductsAndSuppliers();
}
