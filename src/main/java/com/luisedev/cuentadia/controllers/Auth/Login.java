package com.luisedev.cuentadia.controllers.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public class Login {

    @PostMapping("/login")
    public ResponseEntity<Boolean> login() {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUsers(){
        return ResponseEntity.ok(true);
    }
}
