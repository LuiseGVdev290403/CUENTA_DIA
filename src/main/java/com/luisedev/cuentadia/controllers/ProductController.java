package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.ProductRequest;
import com.luisedev.cuentadia.dto.response.ProductResponse;
import com.luisedev.cuentadia.mappers.Product.IProductMapper;
import com.luisedev.cuentadia.services.Product.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productMapper;

    public ProductController(IProductService productMapper) {
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<ProductResponse> productResponseList  = productMapper.productResponseList();
        return ResponseEntity.ok(productResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse>  getProductResponse(@PathVariable Long id) {
        ProductResponse productResponse = productMapper.productById(id);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productMapper.productSaved(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productMapper.eliminatedProductById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content si se borró
        }
        return ResponseEntity.notFound().build(); // Retorna 404 si no existía
    }
}
