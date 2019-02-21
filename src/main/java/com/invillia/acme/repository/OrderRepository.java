package com.invillia.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderStatus;
import com.invillia.acme.domain.store.Store;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByStore(Store store);
    
    List<Order> findByOrderStatus(OrderStatus orderStatus);
    
    List<Order> findByOrderStatusAndStore(OrderStatus orderStatus, Store store);
    
}
