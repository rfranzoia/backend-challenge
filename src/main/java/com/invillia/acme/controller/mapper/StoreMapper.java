package com.invillia.acme.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.invillia.acme.domain.store.Store;
import com.invillia.acme.dto.StoreDTO;

public class StoreMapper
{
    public static Store makeStore(StoreDTO store)
    {
        return new Store(store.getName(), store.getAddress());
    }


    public static StoreDTO makeStoreDTO(Store store)
    {
        StoreDTO.StoreDTOBuilder storeDTOBuilder = StoreDTO.newBuilder()
            .setId(store.getId())
            .setName(store.getName())
            .setAddress(store.getAddress());

        return storeDTOBuilder.createStoreDTO();
    }


    public static List<StoreDTO> makeStoreDTOList(Collection<Store> stores)
    {
        return stores.stream()
            .map(StoreMapper::makeStoreDTO)
            .collect(Collectors.toList());
    }
    
}
