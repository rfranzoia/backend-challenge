package com.acme.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.acme.domain.order.OrderPaymentStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderPaymentDTO {
	@JsonIgnore
	private Long id;

	@NotNull(message = "Order cannot be null!")
	private OrderDTO order;

	@NotNull(message = "Credit Card Number cannot be null!")
	private String creditCardNumber;

	@NotNull(message = "Order Status cannot be null!")
	private OrderPaymentStatus orderPaymentStatus;

	private OrderPaymentDTO() {
	}

	private OrderPaymentDTO(Long id, OrderDTO order, String creditCardNumber, OrderPaymentStatus orderPaymentStatus) {
		this.id = id;
		this.order = order;
		this.creditCardNumber = creditCardNumber;
		this.orderPaymentStatus = orderPaymentStatus;
	}

	public static OrderPaymentDTOBuilder newBuilder() {
		return new OrderPaymentDTOBuilder();
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
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	@JsonProperty
	public OrderPaymentStatus getOrderPaymentStatus() {
		return orderPaymentStatus;
	}

	public static class OrderPaymentDTOBuilder {
		private Long id;
		private OrderDTO order;
		private String creditCardNumber;
		private OrderPaymentStatus orderPaymentStatus;

		public OrderPaymentDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public OrderPaymentDTOBuilder setOrder(OrderDTO order) {
			this.order = order;
			return this;
		}

		public OrderPaymentDTOBuilder setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public OrderPaymentDTOBuilder setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
			this.orderPaymentStatus = orderPaymentStatus;
			return this;
		}

		public OrderPaymentDTO createOrderPaymentDTO() {
			return new OrderPaymentDTO(id, order, creditCardNumber, orderPaymentStatus);
		}
	}
}
