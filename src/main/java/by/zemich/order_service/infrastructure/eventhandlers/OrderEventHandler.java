package by.zemich.order_service.infrastructure.eventhandlers;

import by.zemich.order_service.domain.events.DeliveryDateAssignedEvent;
import by.zemich.order_service.domain.events.OrderCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.messaging.MetaData;
import org.springframework.stereotype.Service;

@ProcessingGroup("order-service-processor")
@Service
public class OrderEventHandler {


    @EventSourcingHandler
    public void on(OrderCreatedEvent event, MetaData metaData) {
        System.out.println(metaData);
        System.out.println(event);
    }

    @EventSourcingHandler
    public void on(DeliveryDateAssignedEvent event, MetaData metaData) {
        System.out.println(metaData);
        System.out.println(event);
    }
}
