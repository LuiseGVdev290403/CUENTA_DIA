package com.luisedev.cuentadia.dto.response;

import java.util.Date;

public record ProductResponse(
        Long id,
        String name,
        String description,
        double price,
        String unitMEd,
        Date date
) {
}
