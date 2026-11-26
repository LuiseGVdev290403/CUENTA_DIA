package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="voucher")
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double price;
    private Date date;
    private String receipt_url; // photo voucher

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "idStore")
    private Store store;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "voucher")
    private Set<VoucherDetail> voucherDetails;

    @ManyToMany(mappedBy = "vouchers")
    private Set<Tags> tags;



}
