package com.invillia.acme.domain;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated = ZonedDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime confirmationDate = ZonedDateTime.now();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderPayment> payments;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public ZonedDateTime getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
	this.dateCreated = dateCreated;
    }

    public Boolean getDeleted() {
	return deleted;
    }

    public void setDeleted(Boolean deleted) {
	this.deleted = deleted;
    }

    public ZonedDateTime getDateUpdated() {
	return dateUpdated;
    }

    public void setDateUpdated(ZonedDateTime dateUpdated) {
	this.dateUpdated = dateUpdated;
    }

    public Store getStore() {
	return store;
    }

    public void setStore(Store store) {
	this.store = store;
    }

    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
    }

    public ZonedDateTime getConfirmationDate() {
	return confirmationDate;
    }

    public void setConfirmationDate(ZonedDateTime confirmationDate) {
	this.confirmationDate = confirmationDate;
    }

    public List<OrderItem> getItems() {
	return items;
    }

    public void setItems(List<OrderItem> items) {
	this.items = items;
    }

    public List<OrderPayment> getPayments() {
	return payments;
    }

    public void setPayments(List<OrderPayment> payments) {
	this.payments = payments;
    }

}
