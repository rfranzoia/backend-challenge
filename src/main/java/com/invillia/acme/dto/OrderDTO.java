package com.invillia.acme.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.domain.OrderStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    @JsonIgnore
    private Long id;

    @NotNull(message = "Store cannot be null!")
    private StoreDTO store;

    @NotNull(message = "Order Status cannot be null!")
    private OrderStatus orderStatus;
    
    private List<OrderItemDTO> items;
    
    private List<OrderPaymentDTO> payments;

    private OrderDTO() {
    }

    private OrderDTO(Long id, StoreDTO store, OrderStatus orderStatus, List<OrderItemDTO> items) {
	this.id = id; 
	this.store = store;
	this.orderStatus = orderStatus;
	this.items = items;
	this.payments = new ArrayList<OrderPaymentDTO>();
    }
    
    private OrderDTO(Long id, StoreDTO store, OrderStatus orderStatus, List<OrderItemDTO> items, List<OrderPaymentDTO> payments) {
	this.id = id; 
	this.store = store;
	this.orderStatus = orderStatus;
	this.items = items;
	this.payments = payments;
    }

    public static OrderDTOBuilder newBuilder() {
	return new OrderDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
	return id;
    }

    @JsonProperty
    public StoreDTO getStore() {
	return store;
    }

    @JsonProperty
    public OrderStatus getOrderStatus() {
	return orderStatus;
    }
    
    @JsonProperty
    public List<OrderItemDTO> getItems() {
	return items;
    }
    
    @JsonProperty
    public List<OrderPaymentDTO> getPayments() {
	return payments;
    }

    public static class OrderDTOBuilder {
	private Long id;
	private StoreDTO store;
	private OrderStatus orderStatus;
	private List<OrderItemDTO> items;
	private List<OrderPaymentDTO> payments;

	public OrderDTOBuilder setId(Long id) {
	    this.id = id;
	    return this;
	}

	public OrderDTOBuilder setStore(StoreDTO store) {
	    this.store = store;
	    return this;
	}

	public OrderDTOBuilder setOrderStatus(OrderStatus orderStatus) {
	    this.orderStatus = orderStatus;
	    return this;
	}
	
	public OrderDTOBuilder setItems(List<OrderItemDTO> items) {
	    this.items = items;
	    return this;
	}
	
	public OrderDTOBuilder setPayments(List<OrderPaymentDTO> payments) {
	    this.payments = payments;
	    return this;
	}

	public OrderDTO createOrderDTO() {
	    if (payments == null) {
		return new OrderDTO(id, store, orderStatus, items);
		
	    } else {
		return new OrderDTO(id, store, orderStatus, items, payments);
	    }
	}
    }
}
