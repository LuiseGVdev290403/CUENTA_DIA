package com.luisedev.cuentadia.dto.requets;

import java.util.Date;

public record ProductRequest(
        String name,
        String description,
        double price,
        String unitMEd,
        Date date
) {
}
