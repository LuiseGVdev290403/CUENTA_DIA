package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VoucherDetail")
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double quantity;
    private double unit_price;
    private double subtotal;


    @ManyToOne
    @JoinColumn(name="voucher_id", nullable = false)
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;
}
