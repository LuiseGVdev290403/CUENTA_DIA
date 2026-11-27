package com.luisedev.cuentadia.mappers.voucher;

import com.luisedev.cuentadia.dto.requets.VoucherDetailRequest;
import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.entities.Voucher;
import com.luisedev.cuentadia.entities.VoucherDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherMapper {

    VoucherResponse toVoucherEResposnse (Voucher voucherRequest);
    Voucher toVoucherEntity (VoucherRequest voucherRequest);
    List<VoucherResponse> toVoucherResponseList(List<Voucher> voucherList);
    VoucherDetail toVoucherDetail (Voucher voucher, VoucherDetailRequest voucherDetailRequest);
}
