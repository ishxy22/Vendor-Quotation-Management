package com.vendor.quotation_management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vendor.quotation_management.entity.Product;
import com.vendor.quotation_management.repository.ProductRepository;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository repo;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/product/{id}")
    public Object getProductById(@PathVariable Long id) {
        Product product = repo.findById(id).orElse(null);
        if (product == null) {
            return "Product Not Found";
        }
        logger.info("Product found: {}", product);
        return product;
    }

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product) {
        logger.info("Product Saved Successfully: {}", product);
        return repo.save(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return "Product Not Found";
        }
        repo.deleteById(id);
        logger.info("Product deleted successfully with id: {}", id);
        return "Product deleted successfully";
    }

    @PutMapping("/updateproduct/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (!repo.existsById(id)) {
            return "Product not found";
        }
        product.setProductId(id);
        repo.save(product);
        logger.info("Product updated successfully: {}", product);
        return "Product updated successfully";
    }
}
