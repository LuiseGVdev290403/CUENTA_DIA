package com.luisedev.cuentadia.repository;

import com.luisedev.cuentadia.entities.VoucherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherDetailRepository extends JpaRepository<VoucherDetail, Long> {
}
