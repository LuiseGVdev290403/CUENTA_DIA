package com.luisedev.cuentadia.services.Product;

import com.luisedev.cuentadia.dto.requets.ProductRequest;
import com.luisedev.cuentadia.dto.response.ProductResponse;
import com.luisedev.cuentadia.entities.Product;
import com.luisedev.cuentadia.mappers.Product.IProductMapper;
import com.luisedev.cuentadia.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProductService{

    private final  IProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductImpl(IProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductResponse> productResponseList() {
        List<Product> products = productRepository.findAll();
        return productMapper.productList(products);
    }

    @Override
    public ProductResponse productSaved(ProductRequest productRequest) {
        Product product = productMapper.toProductEntity(productRequest);
        Product productSaved = productRepository.save(product);
        return productMapper.toProductResponse(productSaved);
    }

    @Override
    public boolean eliminatedProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProductResponse productById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with this id not exists"));
        return productMapper.toProductResponse(product);
    }
}
