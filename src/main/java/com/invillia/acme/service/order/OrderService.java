package com.invillia.acme.service.order;

import java.util.List;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderItem;
import com.invillia.acme.domain.order.OrderPayment;
import com.invillia.acme.domain.order.OrderStatus;
import com.invillia.acme.domain.store.Store;
import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;

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