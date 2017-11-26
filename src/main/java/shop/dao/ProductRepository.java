package shop.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.models.Product;


@Transactional
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
