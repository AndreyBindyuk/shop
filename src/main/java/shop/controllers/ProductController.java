package shop.controllers;


import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.models.Product;
import shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public boolean createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    public WriteResult deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @RequestMapping(value = "/findProductsWithDynamicFilters", method = RequestMethod.GET)
    public List<Product> findProductsWithDynamicFilters(@ModelAttribute Product product){
        return productService.findAllProductsWithDynamicaFilters(product);
    }
}
