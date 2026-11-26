package com.luisedev.cuentadia.services.Product;

import com.luisedev.cuentadia.dto.requets.ProductRequest;
import com.luisedev.cuentadia.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> productResponseList ();
    ProductResponse productSaved(ProductRequest productRequest);
    boolean eliminatedProductById(Long id);
    ProductResponse productById (Long id);
}
