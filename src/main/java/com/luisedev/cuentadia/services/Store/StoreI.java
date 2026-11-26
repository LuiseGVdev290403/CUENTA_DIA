package com.luisedev.cuentadia.services.Store;

import com.luisedev.cuentadia.dto.requets.StoreRequest;
import com.luisedev.cuentadia.dto.response.StoreResponse;

import java.util.List;

public interface StoreI {
    // listas de tiendas
    List<StoreResponse> storeResponseList();
    StoreResponse storeSave (StoreRequest store); // guardar store
    boolean deleteStore (Long id);
    StoreResponse findStoreById(Long id);


}
