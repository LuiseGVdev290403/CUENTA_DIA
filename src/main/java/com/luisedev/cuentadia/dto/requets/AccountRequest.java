package com.luisedev.cuentadia.dto.requets;

public record AccountRequest(
        String name,
        double initialBalance, // balance inicial
        String type
) {
}
