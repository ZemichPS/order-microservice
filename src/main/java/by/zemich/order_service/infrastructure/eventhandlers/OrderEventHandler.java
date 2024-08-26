package by.zemich.order_service.infrastructure.eventhandlers;

import by.zemich.order_service.domain.events.DeliveryDateAssignedEvent;
import by.zemich.order_service.domain.events.OrderCreatedEvent;
import lombok.extern.log4j.Log4j2;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.messaging.MetaData;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

@ProcessingGroup("order-subscribing-event-processor")
@Service
@Log4j2
public class OrderEventHandler {


    @EventSourcingHandler
    public void on(OrderCreatedEvent event, MetaData metaData) {
        System.out.println(event);
        System.out.println(metaData);
    }

    @EventSourcingHandler
    public void on(DeliveryDateAssignedEvent event, MetaData metaData) {
        System.out.println(metaData);
        System.out.println(event);
    }

}
