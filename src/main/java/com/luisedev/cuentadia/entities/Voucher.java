package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
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

    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VoucherDetail> voucherDetails;

    @ManyToMany(mappedBy = "vouchers")
    private Set<Tags> tags;

    public Voucher(double price, String description, Date date, String receipt_url, Users user, Store store, Account account,  Set<Tags> tags, Set<VoucherDetail> voucherDetails ) {
        this.price = price;
        this.description = description;
        this.date = date;
        this.receipt_url = receipt_url;
        this.user = user;
        this.store = store;
        this.account = account;
        this.tags = tags;
        this.voucherDetails = voucherDetails;
    }
}
