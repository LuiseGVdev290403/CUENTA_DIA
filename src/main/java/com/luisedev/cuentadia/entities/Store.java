package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStore;

    private String name;
    private String description;

    public Store (String name, String description) {
        this.name = name;
        this.description = description;
    }


    @OneToOne(mappedBy = "store")
    private Voucher voucher;

}
