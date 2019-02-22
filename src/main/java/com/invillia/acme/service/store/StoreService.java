package com.invillia.acme.service.store;

import java.util.List;

import com.invillia.acme.domain.store.Store;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;

public interface StoreService {

    Store find(Long storeId) throws EntityNotFoundException;

    Store create(Store storeDO) throws ConstraintsViolationException;

    void delete(Long storeId) throws EntityNotFoundException;

    void update(long storeId, String name, String address) throws EntityNotFoundException;

    List<Store> findByName(String name);

    List<Store> findAll();

}