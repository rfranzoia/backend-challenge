package com.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acme.domain.store.Store;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface StoreRepository extends CrudRepository<Store, Long> {

    List<Store> findByNameLike(String name);

}
