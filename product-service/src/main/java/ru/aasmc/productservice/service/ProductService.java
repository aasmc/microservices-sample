package ru.aasmc.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.aasmc.productservice.dto.ProductRequest;
import ru.aasmc.productservice.dto.ProductResponse;
import ru.aasmc.productservice.model.Product;
import ru.aasmc.productservice.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        var saved = productRepository.save(product);
        log.info("Product {}  is saved", product.getId());
        return mapToProductResponse(saved);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
