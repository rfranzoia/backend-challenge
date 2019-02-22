package com.invillia.acme.service.store;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.domain.store.Store;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;
import com.invillia.acme.repository.StoreRepository;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some store specific things.
 * <p/>
 */
@Service
public class DefaultStoreService implements StoreService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultStoreService.class);

    private final StoreRepository storeRepository;


    public DefaultStoreService(final StoreRepository storeRepository)
    {
        this.storeRepository = storeRepository;
    }


    /**
     * Selects a store by id.
     *
     * @param storeId
     * @return found store
     * @throws EntityNotFoundException if no store with the given id was found.
     */
    @Override
    public Store find(Long storeId) throws EntityNotFoundException
    {
        return findStoreChecked(storeId);
    }
    
    /**
     * Creates a new store.
     *
     * @param storeDO
     * @return
     * @throws ConstraintsViolationException if a store already exists with the given license plate, ... .
     */
    @Override
    public Store create(Store storeDO) throws ConstraintsViolationException
    {
        Store store;
        try
        {
            store = storeRepository.save(storeDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a store: {}", storeDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return store;
    }


    /**
     * Deletes an existing store by id.
     *
     * @param storeId
     * @throws EntityNotFoundException if no store with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long storeId) throws EntityNotFoundException
    {
        Store storeDO = findStoreChecked(storeId);
        storeDO.setDeleted(true);
    }


    /**
     * Update the location for a store.
     *
     * @param storeId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void update(long storeId, String name, String address) throws EntityNotFoundException
    {
        Store store = findStoreChecked(storeId);
        store.setName(name);
        store.setAddress(address);
    }


    /**
     * Find all stores.
     *
     */
    @Override
    public List<Store> findAll()
    {
        List<Store> list = new ArrayList<>();
        storeRepository.findAll().forEach(c -> {
            list.add(c);
        });
        return list;
    }
    
    
    /**
     * Find all stores by name.
     *
     * @param name
     */
    @Override
    public List<Store> findByName(String name)
    {
        return storeRepository.findByNameLike(name + "%");
    }
    
    private Store findStoreChecked(Long storeId) throws EntityNotFoundException
    {
        return storeRepository.findById(storeId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + storeId));
    }
    
}
