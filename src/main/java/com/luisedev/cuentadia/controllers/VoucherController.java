package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.VoucherRequest;
import com.luisedev.cuentadia.dto.response.VoucherResponse;
import com.luisedev.cuentadia.services.Voucher.VoucherServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {
    private final VoucherServices voucherServices;

    public VoucherController(VoucherServices voucherServices) {
        this.voucherServices = voucherServices;
    }

    @GetMapping
    public ResponseEntity<List<VoucherResponse>> getAllVoucher () {
        return ResponseEntity.ok(voucherServices.voucherResponseList());
    }

    @PostMapping
    public ResponseEntity<VoucherResponse> savedVoucher(@RequestBody VoucherRequest voucherRequest) {
        System.out.println("Controller : " + voucherRequest.voucherDetails().isEmpty());
        return ResponseEntity.status(HttpStatus.CREATED).body(voucherServices.voucherResponseSave(voucherRequest));
    }
}
