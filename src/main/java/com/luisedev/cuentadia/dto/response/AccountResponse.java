package com.luisedev.cuentadia.dto.response;

public record AccountResponse(
        Long id,
        String name,
        String type,
        double initialBalance
){
}
