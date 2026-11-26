package com.luisedev.cuentadia.mappers.Store;


import com.luisedev.cuentadia.dto.requets.StoreRequest;
import com.luisedev.cuentadia.dto.response.StoreResponse;
import com.luisedev.cuentadia.entities.Store;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring") // <-- Esto le dice a MapStruct que cree un Bean para Spring
public interface IStoreMapper {

    Store toStoreEntity (StoreRequest storeRequest);
    StoreResponse toStoreResponse(Store store);
    List<StoreResponse> toStoreResponseList(List<Store> storeList);

}
