package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.StoreRequest;
import com.luisedev.cuentadia.dto.response.StoreResponse;
import com.luisedev.cuentadia.services.Store.StoreI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreI storeServices;

    public StoreController(StoreI storeServices) {
        this.storeServices = storeServices;
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> getAllStore () {
        List<StoreResponse> storeResponseList = storeServices.storeResponseList();
        return ResponseEntity.ok(storeResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getStoreById(@PathVariable  Long id){
        StoreResponse storeResponse = storeServices.findStoreById(id);
        return ResponseEntity.ok(storeResponse);
    }

    @PostMapping
    public ResponseEntity<StoreResponse> createStore(@RequestBody StoreRequest storeRequest){
        StoreResponse storeResponse = storeServices.storeSave(storeRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(storeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        boolean deleted = storeServices.deleteStore(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content si se borró
        }
        return ResponseEntity.notFound().build(); // Retorna 404 si no existía
    }

}
