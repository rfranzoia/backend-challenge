package com.acme.service.store;

import java.util.List;

import com.acme.domain.store.Store;
import com.acme.excepttion.ConstraintsViolationException;
import com.acme.excepttion.EntityNotFoundException;

public interface StoreService {

    Store find(Long storeId) throws EntityNotFoundException;

    Store create(Store storeDO) throws ConstraintsViolationException;

    void delete(Long storeId) throws EntityNotFoundException;

    void update(long storeId, String name, String address) throws EntityNotFoundException;

    List<Store> findByName(String name);

    List<Store> findAll();

}