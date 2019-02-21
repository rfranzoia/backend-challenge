package com.invillia.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderItem;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);
    
}
