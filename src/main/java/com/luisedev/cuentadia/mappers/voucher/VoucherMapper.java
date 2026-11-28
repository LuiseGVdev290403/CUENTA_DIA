package com.luisedev.cuentadia.mappers.voucher;

import com.luisedev.cuentadia.dto.requets.VoucherDetailRequest;
import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.entities.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;


public interface VoucherMapper {

    VoucherResponse toVoucherEResposnse (Voucher voucherRequest);
    Voucher toVoucherEntity (VoucherRequest voucherRequest, Users user, Store store, Account account, Set<Tags> tags, List<Product> productsFound);
    List<VoucherResponse> toVoucherResponseList(List<Voucher> voucherList);
    //VoucherDetail toVoucherDetail (Voucher voucher, VoucherDetailRequest voucherDetailRequest);
}
