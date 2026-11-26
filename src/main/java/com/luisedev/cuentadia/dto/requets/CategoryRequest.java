package com.luisedev.cuentadia.dto.requets;

public record CategoryRequest(
        String name,
        String description,
        String type,
        boolean active

) {
}
