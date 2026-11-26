package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.AccountRequest;
import com.luisedev.cuentadia.dto.response.AccountResponse;
import com.luisedev.cuentadia.services.Account.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final IAccountService iAccountService;

    public AccountController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccount() {
        return ResponseEntity.ok(iAccountService.accountResponsesList());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AccountResponse> getAccountBId(@PathVariable Long id) {
        return ResponseEntity.ok(iAccountService.accountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountResponse> saveAccount(@RequestBody AccountRequest accountRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iAccountService.accountSave(accountRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedAccount(@PathVariable Long id) {
        boolean deleted = iAccountService.accountDeleted(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content si se borró
        }
        return ResponseEntity.notFound().build();
    }


}
