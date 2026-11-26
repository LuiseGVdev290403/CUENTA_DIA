package com.luisedev.cuentadia.dto.requets;

public record UsersRequest(
        String name,
        String lastName,
        String userName,
        String password
) {}
