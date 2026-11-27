package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private double price;
    @Column(name="unit_med")
    private String unitMed;

    private Date date;
    @ManyToMany
    @JoinTable(
            name="product_category",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories;

    @OneToMany(mappedBy = "product")
    private Set<VoucherDetail> voucherDetails;

    public Product(String name, String description, String unitMed, double price, Date date) {
        this.name = name;
        this.description = description;
        this.unitMed = unitMed;
        this.price = price;
        this.date = date;
    }
}
