package shop.services;

import shop.models.Product;

import java.util.List;

public interface ProductService {

    boolean createProduct(Product product);

    Product deleteProduct(String productId);

    List<Product> findAllProducts();

    List<Product> findAllProductsWithDynamicaFilters(Product product);
}
