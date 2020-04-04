package com.acme.controller;

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

import com.acme.controller.mapper.StoreMapper;
import com.acme.domain.store.Store;
import com.acme.dto.StoreDTO;
import com.acme.excepttion.ConstraintsViolationException;
import com.acme.excepttion.EntityNotFoundException;
import com.acme.service.store.StoreService;

/**
 * All operations with a store will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/stores")
public class StoreController {

	private final StoreService storeService;

	@Autowired
	public StoreController(final StoreService storeService) {
		this.storeService = storeService;
	}

	@GetMapping("/{storeId}")
	public StoreDTO getStore(@PathVariable final long storeId) throws EntityNotFoundException {
		return StoreMapper.makeStoreDTO(storeService.find(storeId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StoreDTO createStore(@Valid @RequestBody final StoreDTO storeDTO) throws ConstraintsViolationException {
		Store store = StoreMapper.makeStore(storeDTO);
		return StoreMapper.makeStoreDTO(storeService.create(store));
	}

	@DeleteMapping("/{storeId}")
	public void deleteStore(@PathVariable final long storeId) throws EntityNotFoundException {
		storeService.delete(storeId);
	}

	@PutMapping("/{storeId}")
	public void updateLocation(@PathVariable final long storeId, @RequestParam final String name, @RequestParam final String address)
			throws EntityNotFoundException {
		storeService.update(storeId, name, address);
	}

	@GetMapping("/name/{name}")
	public List<StoreDTO> findStoresByName(@PathVariable final String name) {
		return StoreMapper.makeStoreDTOList(storeService.findByName(name));
	}

	@GetMapping
	public List<StoreDTO> findAllStores() {
		return StoreMapper.makeStoreDTOList(storeService.findAll());
	}
}
