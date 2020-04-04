package com.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acme.domain.order.Order;
import com.acme.domain.order.OrderPayment;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface OrderPaymentRepository extends CrudRepository<OrderPayment, Long> {

    List<OrderPayment> findByOrder(Order order);
    
}
