package ru.aasmc.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.aasmc.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
