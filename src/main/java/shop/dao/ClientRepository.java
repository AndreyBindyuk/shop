package shop.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.models.Client;


@Transactional
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
}
