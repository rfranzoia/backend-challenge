package com.invillia.acme.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.domain.Order;
import com.invillia.acme.domain.OrderStatus;
import com.invillia.acme.domain.Store;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByStore(Store store);
    
    List<Order> findByOrderStatus(OrderStatus orderStatus);
    
    List<Order> findByDateCreatedBetween(ZonedDateTime startDate, ZonedDateTime endDate);
    
    List<Order> findByOrderStatusAndDateCreatedBetween(OrderStatus orderStatus, ZonedDateTime startDate, ZonedDateTime endDate);
    
    List<Order> findByPaymentDateBetween(ZonedDateTime startDate, ZonedDateTime endDate);

}
