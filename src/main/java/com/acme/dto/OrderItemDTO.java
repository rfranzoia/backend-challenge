package com.acme.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {
	@JsonIgnore
	private Long id;

	@NotNull(message = "Order cannot be null!")
	private OrderDTO order;

	@NotNull(message = "Description cannot be null!")
	private String description;

	@NotNull(message = "Unit Price cannot be null!")
	private Double unitPrice;

	@NotNull(message = "Quantity cannot be null!")
	private Integer quantity;

	private OrderItemDTO() {
	}

	private OrderItemDTO(Long id, OrderDTO order, String description, Double unitPrice, Integer quantity) {
		this.id = id;
		this.order = order;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public static OrderItemDTOBuilder newBuilder() {
		return new OrderItemDTOBuilder();
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public OrderDTO getOrder() {
		return order;
	}

	@JsonProperty
	public String getDescription() {
		return description;
	}

	@JsonProperty
	public Double getUnitPrice() {
		return unitPrice;
	}

	@JsonProperty
	public Integer getQuantity() {
		return quantity;
	}

	public static class OrderItemDTOBuilder {
		private Long id;
		private OrderDTO order;
		private String description;
		private Double unitPrice;
		private Integer quantity;

		public OrderItemDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public OrderItemDTOBuilder setOrder(OrderDTO order) {
			this.order = order;
			return this;
		}

		public OrderItemDTOBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public OrderItemDTOBuilder setUnitPrice(Double unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}

		public OrderItemDTOBuilder setQuantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public OrderItemDTO createOrderItemDTO() {
			return new OrderItemDTO(id, order, description, unitPrice, quantity);
		}
	}
}
