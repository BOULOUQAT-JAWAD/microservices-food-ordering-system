package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent{

    private final DomainEventPublisher<OrderPaidEvent> paidEventDomainEventPublisher;
    public OrderPaidEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderPaidEvent> paidEventDomainEventPublisher) {
        super(order, createdAt);
        this.paidEventDomainEventPublisher = paidEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        paidEventDomainEventPublisher.publish(this);
    }
}