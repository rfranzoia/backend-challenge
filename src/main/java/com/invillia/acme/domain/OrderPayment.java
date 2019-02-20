package com.invillia.acme.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "order_payment")
public class OrderPayment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderPaymentStatus orderPaymentStatus;

    @Column(nullable = false)
    @NotNull(message = "Item Description cannot be null!")
    private String creditCardNumber;

    @Column(nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime paymentDate;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Order getOrder() {
	return order;
    }

    public void setOrder(Order order) {
	this.order = order;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
	return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
	this.orderPaymentStatus = orderPaymentStatus;
    }

    public String getCreditCardNumber() {
	return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
	this.creditCardNumber = creditCardNumber;
    }

    public ZonedDateTime getPaymentDate() {
	return paymentDate;
    }

    public void setPaymentDate(ZonedDateTime paymentDate) {
	this.paymentDate = paymentDate;
    }

}
