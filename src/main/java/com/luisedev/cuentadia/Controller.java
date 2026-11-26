package com.luisedev.cuentadia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String nombre(){
        return "aaa por fin mierda";
    }
}
