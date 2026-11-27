package com.luisedev.cuentadia.mappers.Product;

import com.luisedev.cuentadia.dto.requets.ProductRequest;
import com.luisedev.cuentadia.dto.response.ProductResponse;
import com.luisedev.cuentadia.entities.Product;

import java.util.List;


public class ProductImpl implements IProductMapper {

    @Override
    public Product toProductEntity(ProductRequest productRequest) {

        if (productRequest == null) {
            return null;
        }
        return new Product (
                productRequest.name(),
                productRequest.description(),
                productRequest.unit_med(),
                productRequest.price(),
                productRequest.date()
        );
    }

    @Override
    public List<ProductResponse> productList(List<Product> products) {
        if (products.isEmpty()) {
            return  null;
        }
        return (List<ProductResponse>) products.stream().map(p -> {
            return new ProductResponse (
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getPrice(),
                    p.getUnitMed(),
                    p.getDate()
            );
        }).toList();
    }

    @Override
    public ProductResponse toProductResponse(Product p) {
        if (p == null) {
            return  null;
        }
        return new ProductResponse (
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getUnitMed(),
                p.getDate()
        );
    }
}
