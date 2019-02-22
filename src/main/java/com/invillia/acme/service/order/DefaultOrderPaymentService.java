package com.invillia.acme.service.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderPayment;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;
import com.invillia.acme.repository.OrderPaymentRepository;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some orderPayment specific things.
 * <p/>
 */
@Service
public class DefaultOrderPaymentService implements OrderPaymentService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultOrderPaymentService.class);

    private final OrderPaymentRepository orderPaymentRepository;


    public DefaultOrderPaymentService(final OrderPaymentRepository orderPaymentRepository)
    {
        this.orderPaymentRepository = orderPaymentRepository;
    }


    /**
     * Selects a orderPayment by id.
     *
     * @param orderPaymentId
     * @return found orderPayment
     * @throws EntityNotFoundException if no orderPayment with the given id was found.
     */
    @Override
    public OrderPayment find(Long orderPaymentId) throws EntityNotFoundException
    {
        return findOrderPaymentChecked(orderPaymentId);
    }
    
    /**
     * Creates a new orderPayment.
     *
     * @param orderPaymentDO
     * @return
     * @throws ConstraintsViolationException if a orderPayment already exists with the given license plate, ... .
     */
    @Override
    public OrderPayment create(OrderPayment orderPaymentDO) throws ConstraintsViolationException
    {
        OrderPayment orderPayment;
        try
        {
            orderPayment = orderPaymentRepository.save(orderPaymentDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a orderPayment: {}", orderPaymentDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return orderPayment;
    }


    /**
     * Find all orderPayments by order.
     *
     * @param name
     */
    @Override
    public List<OrderPayment> findByOrder(Order order)
    {
        return orderPaymentRepository.findByOrder(order);
    }
    
    private OrderPayment findOrderPaymentChecked(Long orderPaymentId) throws EntityNotFoundException
    {
        return orderPaymentRepository.findById(orderPaymentId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + orderPaymentId));
    }



    
}
