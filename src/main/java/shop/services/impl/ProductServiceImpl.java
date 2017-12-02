package shop.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import shop.dao.ProductRepository;
import shop.models.Product;
import shop.services.ProductService;

import java.util.Iterator;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public boolean createProduct(Product product) {
        return productRepository.insert(product) != null;
    }

    public Product deleteProduct(String productId) {
        return mongoTemplate.findAndRemove(new Query(new Criteria(productId)), Product.class);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findAllProductsWithDynamicaFilters(Product product) {
        ObjectMapper mapper = new ObjectMapper();
        Criteria criteria = new Criteria();
        try {
            JSONObject jsonpObject = new JSONObject(mapper.writeValueAsString(product));
            Iterator<String> jsonKeys = jsonpObject.keys();
            while (jsonKeys.hasNext()) {
                String key = jsonKeys.next();
                Object value = jsonpObject.get(key);
                criteria.and(key).is(value);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mongoTemplate.find(new Query(criteria), Product.class);
    }
}
