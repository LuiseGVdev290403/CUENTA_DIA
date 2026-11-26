package com.luisedev.cuentadia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Modifying;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Tags(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
            name="vouchers_tags",
            joinColumns = @JoinColumn(name="tags_id"),
            inverseJoinColumns = @JoinColumn(name="voucher_id")
    )
    private Set<Voucher> vouchers;

}
