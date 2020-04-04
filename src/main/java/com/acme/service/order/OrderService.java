package com.acme.service.order;

import java.util.List;

import com.acme.domain.order.Order;
import com.acme.domain.order.OrderItem;
import com.acme.domain.order.OrderPayment;
import com.acme.domain.order.OrderStatus;
import com.acme.domain.store.Store;
import com.acme.dto.OrderDTO;
import com.acme.excepttion.ConstraintsViolationException;
import com.acme.excepttion.EntityNotFoundException;

public interface OrderService {

    OrderDTO find(Long orderId) throws EntityNotFoundException;

    OrderDTO create(Order order, OrderItem items) throws ConstraintsViolationException;
    
    OrderDTO create(Order order) throws ConstraintsViolationException;

    void delete(Long orderId) throws EntityNotFoundException;

    void update(long orderId, Store store) throws EntityNotFoundException;
    
    void updateOrderStatus(long orderId, OrderStatus orderStatus);
    
    void updateOrderPayment(long orderId, OrderPayment orderPayment) throws EntityNotFoundException;
    
    List<OrderDTO> findAll();
    
    List<OrderDTO> findByOrderStatus(OrderStatus orderStatus);
    
    List<OrderDTO> findByOrderStatusAndStore(OrderStatus orderStatus, Store store);
    
    List<OrderDTO> findByStore(Store store);
    

}