package com.invillia.acme.service.order;

import java.util.List;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderPayment;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;

public interface OrderPaymentService {

    OrderPayment find(Long orderPaymentId) throws EntityNotFoundException;

    OrderPayment create(OrderPayment orderPayment) throws ConstraintsViolationException;

    List<OrderPayment> findByOrder(Order order);

}