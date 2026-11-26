package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="account")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Column(name = "initial_balance")
    private double initialBalance;


    @OneToMany(mappedBy = "account")
    private Set<Recurring_expenses> recurringExpenses;

    @OneToOne(mappedBy = "account")
    private Voucher voucher;

    public Account(String name, String type, double initialBalance) {
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
    }

}
