package com.luisedev.cuentadia.mappers.Product;

import com.luisedev.cuentadia.dto.requets.ProductRequest;
import com.luisedev.cuentadia.dto.response.ProductResponse;
import com.luisedev.cuentadia.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    Product toProductEntity(ProductRequest productRequest);
    List<ProductResponse> productList(List<Product> products);
    ProductResponse toProductResponse (Product product);

}
