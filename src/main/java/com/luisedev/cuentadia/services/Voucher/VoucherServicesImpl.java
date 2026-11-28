package com.luisedev.cuentadia.services.Voucher;

import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.entities.*;
import com.luisedev.cuentadia.mappers.voucher.VoucherMapper;
import com.luisedev.cuentadia.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VoucherServicesImpl implements VoucherServices {
    private final VoucherMapper voucherMapper;
    private final VoucherRepository voucherRepository;
    private final UsersRepository usersRepository;
    private final StoreRepository storeRepository;
    private final AccountRepository accountRepository;
    private final TagsRepository tagsRepository;
    private final ProductRepository productRepository;



    public VoucherServicesImpl(VoucherMapper voucherMapper, VoucherRepository voucherRepository, UsersRepository usersRepository, StoreRepository storeRepository, AccountRepository accountRepository, TagsRepository tagsRepository, ProductRepository productRepository) {
        this.voucherMapper = voucherMapper;
        this.voucherRepository = voucherRepository;
        this.usersRepository = usersRepository;
        this.storeRepository = storeRepository;
        this.accountRepository = accountRepository;
        this.tagsRepository = tagsRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<VoucherResponse> voucherResponseList() {
        List<Voucher> voucherList = voucherRepository.findAll();
        return voucherMapper.toVoucherResponseList(voucherList);
    }

    @Override
    public VoucherResponse voucherResponseSave(VoucherRequest voucherRequest) {
        // 1. El servicio busca las entidades en la BD
        Users user = usersRepository.findById(voucherRequest.userId())
                .orElseThrow(() -> new RuntimeException("User not exits in BD"));
        Store store = storeRepository.findById(voucherRequest.storeId())
                .orElseThrow(() -> new RuntimeException("Store not Exits in BD"));
        Account account = accountRepository.findById(voucherRequest.accountId())
                .orElseThrow(() -> new RuntimeException("Account not exits in BD"));

        Set<Tags> tags = voucherRequest.tagsId().stream()
                .map(id -> tagsRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Tags not exits in BD")))
                .collect(Collectors.toSet());

        // 2. Buscamos todos los productos de los detalles de antemano
        List<Product> products = voucherRequest.voucherDetails().stream()
                .map(detailReq -> productRepository.findById(detailReq.productId())
                        .orElseThrow(() -> new RuntimeException("Product not exits with id: " + detailReq.productId())))
                .toList();

        // 3. Llamamos a tu mapper pasando todo por parámetros
        Voucher voucher = voucherMapper.toVoucherEntity(voucherRequest, user, store, account, tags, products);

        // 4. Guardamos
        Voucher voucherSaved = voucherRepository.save(voucher);
        return voucherMapper.toVoucherEResposnse(voucherSaved);
    }

    @Override
    public VoucherResponse voucherById(Long id) {
        return null;
    }
}
