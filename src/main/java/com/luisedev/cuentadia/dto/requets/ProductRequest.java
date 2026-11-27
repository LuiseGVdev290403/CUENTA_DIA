package com.luisedev.cuentadia.dto.requets;

import java.util.Date;

public record ProductRequest(
        String name,
        String description,
        double price,
        String unit_med,
        Date date
) {
}
