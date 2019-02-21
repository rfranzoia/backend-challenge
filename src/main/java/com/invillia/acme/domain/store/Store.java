package com.invillia.acme.domain.store;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "store", uniqueConstraints = @UniqueConstraint(name = "uc_name", columnNames = { "name" }))
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Store Name cannot be null!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Store Address cannot be null!")
    private String address;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated = ZonedDateTime.now();
    
    public Store() {
    }
    
    public Store(String name, String address) {
	this.name = name;
	this.address = address;
	this.deleted = false;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
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

}
