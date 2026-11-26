package com.luisedev.cuentadia.dto.response;

public record UsersResponse(
        Long id,
        String name,
        String lastName,
        String username
) {}
