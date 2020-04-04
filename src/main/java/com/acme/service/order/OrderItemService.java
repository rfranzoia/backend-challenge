package com.acme.service.order;

import java.util.List;

import com.acme.domain.order.Order;
import com.acme.domain.order.OrderItem;
import com.acme.excepttion.ConstraintsViolationException;
import com.acme.excepttion.EntityNotFoundException;

public interface OrderItemService {

    OrderItem find(Long orderItemId) throws EntityNotFoundException;

    OrderItem create(OrderItem orderItem) throws ConstraintsViolationException;

    void delete(Long orderItemId) throws EntityNotFoundException;
    
    void deleteByOrder(Order order) throws EntityNotFoundException;

    List<OrderItem> findByOrder(Order order);

}