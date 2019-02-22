package com.invillia.acme.service.order;

import java.util.List;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderItem;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;

public interface OrderItemService {

    OrderItem find(Long orderItemId) throws EntityNotFoundException;

    OrderItem create(OrderItem orderItem) throws ConstraintsViolationException;

    void delete(Long orderItemId) throws EntityNotFoundException;
    
    void deleteByOrder(Order order) throws EntityNotFoundException;

    List<OrderItem> findByOrder(Order order);

}