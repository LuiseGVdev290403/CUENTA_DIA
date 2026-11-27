package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    public VoucherDetail(String description, double quantity, double unit_price, double subtotal, Voucher voucher, Product product) {
        this.description = description;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.subtotal = subtotal;
        this.voucher = voucher;
        this.product = product;
    }
}
