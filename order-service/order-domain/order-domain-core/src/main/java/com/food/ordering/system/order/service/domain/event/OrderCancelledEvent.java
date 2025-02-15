package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent{

    private final DomainEventPublisher<OrderCancelledEvent> cancelledEventDomainEventPublisher;

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderCancelledEvent> cancelledEventDomainEventPublisher) {
        super(order, createdAt);
        this.cancelledEventDomainEventPublisher = cancelledEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        cancelledEventDomainEventPublisher.publish(this);
    }
}