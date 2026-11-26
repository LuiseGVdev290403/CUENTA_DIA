package com.luisedev.cuentadia.mappers.Store;

import com.luisedev.cuentadia.dto.requets.StoreRequest;
import com.luisedev.cuentadia.dto.response.StoreResponse;
import com.luisedev.cuentadia.entities.Store;

import java.util.Collections;
import java.util.List;

public class IStoreMapperImp implements IStoreMapper {

    @Override
    public Store toStoreEntity(StoreRequest storeRequest) {
        if (storeRequest == null) {
            return null;
        }
        return new Store(
                storeRequest.name(),
                storeRequest.description()
        );
    }

    @Override
    public StoreResponse toStoreResponse(Store store) {
        if (store == null) {
            return null;
        }

        return new StoreResponse(
                store.getIdStore(),
                store.getName(),
                store.getDescription()
        );
    }

    @Override
    public List<StoreResponse> toStoreResponseList(List<Store> storeList) {
        if (storeList == null) {
            return Collections.emptyList();
        }
        return (List<StoreResponse>) storeList.stream()
                .map(store -> {
                    return new StoreResponse(
                           store.getIdStore(),
                           store.getName(),
                           store.getDescription()
                   );
                })
                .toList();
    }
}
