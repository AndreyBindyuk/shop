package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("shop/dao")
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
}
