package com.luisedev.cuentadia.dto.requets;

import java.util.Date;
import java.util.List;

public record VoucherRequest(
    String description,
    double price,
    Date date,
    String receipt_url,
    Long userId,
    Long storeId,
    Long accountId,
    List<Long> tagsId,
    List<VoucherDetailRequest> voucherDetails

) {
}
