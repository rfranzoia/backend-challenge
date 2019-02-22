package com.invillia.acme.service.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.domain.order.Order;
import com.invillia.acme.domain.order.OrderItem;
import com.invillia.acme.excepttion.ConstraintsViolationException;
import com.invillia.acme.excepttion.EntityNotFoundException;
import com.invillia.acme.repository.OrderItemRepository;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some orderItem specific things.
 * <p/>
 */
@Service
public class DefaultOrderItemService implements OrderItemService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultOrderItemService.class);

    private final OrderItemRepository orderItemRepository;


    public DefaultOrderItemService(final OrderItemRepository orderItemRepository)
    {
        this.orderItemRepository = orderItemRepository;
    }


    /**
     * Selects a orderItem by id.
     *
     * @param orderItemId
     * @return found orderItem
     * @throws EntityNotFoundException if no orderItem with the given id was found.
     */
    @Override
    public OrderItem find(Long orderItemId) throws EntityNotFoundException
    {
        return findOrderItemChecked(orderItemId);
    }
    
    /**
     * Creates a new orderItem.
     *
     * @param orderItemDO
     * @return
     * @throws ConstraintsViolationException if a orderItem already exists with the given license plate, ... .
     */
    @Override
    public OrderItem create(OrderItem orderItemDO) throws ConstraintsViolationException
    {
        OrderItem orderItem;
        try
        {
            orderItem = orderItemRepository.save(orderItemDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a orderItem: {}", orderItemDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return orderItem;
    }


    /**
     * Deletes an existing orderItem by id.
     *
     * @param orderItemId
     * @throws EntityNotFoundException if no orderItem with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long orderItemId) throws EntityNotFoundException
    {
        OrderItem orderItemDO = findOrderItemChecked(orderItemId);
        orderItemDO.setDeleted(true);
    }


    /**
     * Find all orderItems by order.
     *
     * @param name
     */
    @Override
    public List<OrderItem> findByOrder(Order order)
    {
        return orderItemRepository.findByOrder(order);
    }
    
    /**
     * Delete all orderItems by order.
     *
     * @param name
     */
    @Override
    public void deleteByOrder(Order order) throws EntityNotFoundException {
	List<OrderItem> items = findByOrder(order);
	items.stream().forEach(item -> {
	    try {
		delete(item.getId());
	    } catch (EntityNotFoundException e) {
		LOG.warn("Could not delete the orderItem: {}", item, e);
	    }
	});
	
    }
    
    private OrderItem findOrderItemChecked(Long orderItemId) throws EntityNotFoundException
    {
        return orderItemRepository.findById(orderItemId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + orderItemId));
    }



    
}
