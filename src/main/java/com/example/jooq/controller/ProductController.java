package com.example.jooq.controller;

import com.example.jooq.model.tables.pojos.Product;
import com.example.jooq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products/insert")
    public Integer insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @DeleteMapping("/products")
    public Integer deleteProduct(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }

    @PostMapping("/products/update")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProducts(product);
    }
}
