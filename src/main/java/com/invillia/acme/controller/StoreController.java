package com.invillia.acme.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.controller.mapper.StoreMapper;
import com.invillia.acme.domain.store.Store;
import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;
import com.invillia.acme.service.store.StoreService;

/**
 * All operations with a store will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/stores")
public class StoreController
{

    private final StoreService storeService;


    @Autowired
    public StoreController(final StoreService storeService)
    {
        this.storeService = storeService;
    }


    @GetMapping("/{storeId}")
    public StoreDTO getStore(@PathVariable long storeId) throws EntityNotFoundException
    {
        return StoreMapper.makeStoreDTO(storeService.find(storeId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreDTO createStore(@Valid @RequestBody StoreDTO storeDTO) throws ConstraintsViolationException
    {
        Store storeDO = StoreMapper.makeStore(storeDTO);
        return StoreMapper.makeStoreDTO(storeService.create(storeDO));
    }


    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable long storeId) throws EntityNotFoundException
    {
        storeService.delete(storeId);
    }


    @PutMapping("/{storeId}")
    public void updateLocation(
        @PathVariable long storeId, @RequestParam String name, @RequestParam String address)
        throws EntityNotFoundException
    {
        storeService.update(storeId, name, address);
    }


    @GetMapping("/name/{name}")
    public List<StoreDTO> findStoresByName(@PathVariable String name)
    {
        return StoreMapper.makeStoreDTOList(storeService.findByName(name));
    }
    
    @GetMapping
    public List<StoreDTO> findAllStores()
    {
        return StoreMapper.makeStoreDTOList(storeService.findAll());
    }
}
