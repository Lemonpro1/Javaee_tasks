package tasks.RestAPI.demo.service;

import tasks.RestAPI.demo.entity.Product;
import tasks.RestAPI.demo.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }
}

