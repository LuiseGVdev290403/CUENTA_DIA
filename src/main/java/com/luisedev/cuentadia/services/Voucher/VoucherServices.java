package com.luisedev.cuentadia.services.Voucher;

import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherResponse;

import java.util.List;

public interface VoucherServices {
    List<VoucherResponse> voucherResponseList();
    VoucherResponse voucherResponseSave(VoucherRequest voucherRequest);
    VoucherResponse voucherById(Long id);
}
