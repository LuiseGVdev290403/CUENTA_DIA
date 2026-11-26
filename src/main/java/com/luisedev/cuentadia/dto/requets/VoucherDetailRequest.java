package com.luisedev.cuentadia.dto.requets;

public record VoucherDetailRequest(
        String description,
        double quantity,
        double unit_price,
        double subtotal,
        Long productId

) {
}
