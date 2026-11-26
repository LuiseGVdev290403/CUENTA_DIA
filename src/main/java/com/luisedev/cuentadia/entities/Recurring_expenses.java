package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="recurring_expenses")
public class Recurring_expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    private String name;
    private double amount;
    private int frequency; // quantities days
    private Date next_date;
    private boolean active;

}
