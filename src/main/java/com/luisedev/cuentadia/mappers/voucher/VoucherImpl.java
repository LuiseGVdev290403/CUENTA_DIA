package com.luisedev.cuentadia.mappers.voucher;

import com.luisedev.cuentadia.dto.requets.VoucherDetailRequest;
import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherDetailResponse;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.entities.Tags;
import com.luisedev.cuentadia.entities.Voucher;
import com.luisedev.cuentadia.entities.VoucherDetail;
import com.luisedev.cuentadia.repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class VoucherImpl implements VoucherMapper{
    private UsersRepository usersRepository;
    private StoreRepository storeRepository;
    private TagsRepository tagsRepository;
    private AccountRepository accountRepository;
    private ProductRepository productRepository;

    public VoucherImpl(UsersRepository usersRepository, StoreRepository storeRepository, TagsRepository tagsRepository, AccountRepository accountRepository, ProductRepository productRepository) {
        this.usersRepository = usersRepository;
        this.storeRepository = storeRepository;
        this.tagsRepository = tagsRepository;
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
    }

    @Override
    public VoucherResponse toVoucherEResposnse(Voucher v) {
        if(v == null) {
            return null;
        }
        return new VoucherResponse(
                v.getId(),
                v.getDescription(),
                v.getPrice(),
                v.getDate(),
                v.getReceipt_url(),
                v.getUser().getId(),
                v.getStore().getIdStore(),
                v.getAccount().getId(),
                v.getVoucherDetails().stream().map(vd -> {
                    return new VoucherDetailResponse(
                            vd.getId(),
                            vd.getDescription(),
                            vd.getQuantity(),
                            vd.getUnit_price(),
                            vd.getSubtotal(),
                            vd.getProduct().getId()
                    );
                }).toList()
        );
    }

    @Override
    public Voucher toVoucherEntity(VoucherRequest voucherRequest) {
        if (voucherRequest == null) {
            return null;
        }
        return new Voucher(
                voucherRequest.price(),
                voucherRequest.description(),
                voucherRequest.date(),
                voucherRequest.receipt_url(),
                usersRepository.findById(voucherRequest.userId()).orElseThrow(() -> new RuntimeException("User not exits in BD")),
                storeRepository.findById(voucherRequest.storeId()).orElseThrow(() -> new RuntimeException("Store not Exits in BD")),
                accountRepository.findById(voucherRequest.accountId()).orElseThrow(() -> new RuntimeException("Account not exits in BD")),
                voucherRequest.tagsId().stream().map(ids -> tagsRepository.findById(ids).orElseThrow(() -> new RuntimeException("Tags not exits in BD"))).collect(Collectors.toSet())
        );
    }

    @Override
    public List<VoucherResponse> toVoucherResponseList(List<Voucher> voucherList) {
        return voucherList.stream().map(v -> {
            return new VoucherResponse(
                    v.getId(),
                    v.getDescription(),
                    v.getPrice(),
                    v.getDate(),
                    v.getReceipt_url(),
                    v.getUser().getId(),
                    v.getStore().getIdStore(),
                    v.getAccount().getId(),
                    v.getVoucherDetails().stream().map(vd -> {
                        return new VoucherDetailResponse(
                                vd.getId(),
                                vd.getDescription(),
                                vd.getQuantity(),
                                vd.getUnit_price(),
                                vd.getSubtotal(),
                                vd.getProduct().getId()
                        );
                    }).toList()
            );
        }).toList();
    }

    @Override
    public VoucherDetail toVoucherDetail(Voucher voucher, VoucherDetailRequest voucherDetailRequest) {
        return new VoucherDetail(
                voucherDetailRequest.description(),
                voucherDetailRequest.quantity(),
                voucherDetailRequest.unit_price(),
                voucherDetailRequest.subtotal(),
                voucher,
                productRepository.findById(voucherDetailRequest.productId()).orElseThrow(() -> new RuntimeException("Product not exit in BD"))
        );
    }
}
