package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String type;

    private boolean active;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;


    @OneToMany(mappedBy = "category")
    private Set<Recurring_expenses> recurringExpenses = new HashSet<>();

    public Category(String name, String description, String type, boolean active) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.active = active;
    }
}
