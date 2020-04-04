package com.acme.service.order;

import java.util.List;

import com.acme.domain.order.Order;
import com.acme.domain.order.OrderPayment;
import com.acme.excepttion.ConstraintsViolationException;
import com.acme.excepttion.EntityNotFoundException;

public interface OrderPaymentService {

    OrderPayment find(Long orderPaymentId) throws EntityNotFoundException;

    OrderPayment create(OrderPayment orderPayment) throws ConstraintsViolationException;

    List<OrderPayment> findByOrder(Order order);

}