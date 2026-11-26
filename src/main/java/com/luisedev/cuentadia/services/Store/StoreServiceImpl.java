package com.luisedev.cuentadia.services.Store;

import com.luisedev.cuentadia.dto.requets.StoreRequest;
import com.luisedev.cuentadia.dto.response.StoreResponse;
import com.luisedev.cuentadia.entities.Store;
import com.luisedev.cuentadia.mappers.Store.IStoreMapper;
import com.luisedev.cuentadia.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreI{


    private final StoreRepository storeRepository;
    private final IStoreMapper IStoreMapper;

    public StoreServiceImpl(StoreRepository storeRepository, IStoreMapper IStoreMapper) {
        this.storeRepository = storeRepository;
        this.IStoreMapper = IStoreMapper;
    }

    @Override
    public List<StoreResponse> storeResponseList() {
        List<Store> storeList = storeRepository.findAll();
        return IStoreMapper.toStoreResponseList(storeList);
    }

    @Override
    public StoreResponse storeSave(StoreRequest storeRequest) {
        Store store = IStoreMapper.toStoreEntity(storeRequest);
        Store storeSaved = storeRepository.save(store);

        return IStoreMapper.toStoreResponse(storeSaved);
    }

    @Override
    public boolean deleteStore(Long id) {
        if (storeRepository.existsById(id)){
            storeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public StoreResponse findStoreById(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
        return IStoreMapper.toStoreResponse(store);
    }
}
