package shop.services;

import com.mongodb.WriteResult;
import shop.models.Product;

import java.util.List;

public interface ProductService {

    boolean createProduct(Product product);
    WriteResult deleteProduct(Product product);
    List<Product> findAllProducts();
    List<Product> findAllProductsWithDynamicaFilters(Product product);
}
