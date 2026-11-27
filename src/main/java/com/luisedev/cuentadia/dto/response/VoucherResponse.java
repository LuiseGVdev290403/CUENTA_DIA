package com.luisedev.cuentadia.dto.response;

import java.util.Date;
import java.util.List;

public record VoucherResponse(
        Long id,
        String description,
        double price,
        Date date,
        String receipt_url,
        Long userId,
        Long storeId,
        Long accountId,
        List<VoucherDetailResponse> voucherDetailResponses
) {}
