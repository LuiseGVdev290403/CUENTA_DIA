package com.luisedev.cuentadia.mappers.voucher;

import com.luisedev.cuentadia.dto.requets.VoucherDetailRequest;
import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherDetailResponse;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.entities.*;
import com.luisedev.cuentadia.repository.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
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

    // Recibe todas las entidades ya buscadas desde el servicio por parámetros
    @Override
    public Voucher toVoucherEntity(VoucherRequest voucherRequest, Users user, Store store, Account account, Set<Tags> tags, List<Product> productsFound) {
        if (voucherRequest == null) {
            return null;
        }

        // 1. Creamos el voucher principal pasando las entidades inyectadas
        Voucher voucher = new Voucher(
                voucherRequest.price(),
                voucherRequest.description(),
                voucherRequest.date(),
                voucherRequest.receipt_url(),
                user,
                store,
                account,
                tags,
                null // Los detalles los asignamos abajo enlazando el voucher padre
        );

        // 2. Mapeamos los detalles vinculando su producto correspondiente y el voucher padre
        Set<VoucherDetail> details = new HashSet<>();
        if (voucherRequest.voucherDetails() != null) {
            for (int i = 0; i < voucherRequest.voucherDetails().size(); i++) {
                var detailReq = voucherRequest.voucherDetails().get(i);
                Product product = productsFound.get(i); // Producto ya resuelto previamente

                VoucherDetail detail = new VoucherDetail(
                        detailReq.description(),
                        detailReq.quantity(),
                        detailReq.unit_price(),
                        detailReq.subtotal(),
                        voucher, // Vincula la llave foránea del padre
                        product  // Vincula el producto real
                );

                details.add(detail);
            }
        }

        voucher.setVoucherDetails(details);
        return voucher;
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

    /*
    *@Override
    public VoucherDetail toVoucherDetail(Voucher voucher, VoucherDetailRequest voucherDetailRequest) {
        return new VoucherDetail(
                voucherDetailRequest.description(),
                voucherDetailRequest.quantity(),
                voucherDetailRequest.unit_price(),
                voucherDetailRequest.subtotal(),
                voucher,
                productRepository.findById(voucherDetailRequest.productId()).orElseThrow(() -> new RuntimeException("Product not exit in BD"))
        );
    }**/
}
