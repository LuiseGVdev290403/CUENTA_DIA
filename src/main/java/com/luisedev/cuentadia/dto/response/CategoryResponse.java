package com.luisedev.cuentadia.dto.response;

public record CategoryResponse(
        Long id,
        String name,
        String description,
        String type,
        boolean active
) {
}
