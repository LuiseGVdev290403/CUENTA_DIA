package com.luisedev.cuentadia.dto.response;

public record VoucherDetailResponse(
        Long id,
        String description,
        double quantity,
        double unit_price,
        double subtotal,
        Long productId
) {}
