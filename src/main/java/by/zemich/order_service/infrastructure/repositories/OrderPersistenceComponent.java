package by.zemich.order_service.infrastructure.repositories;

import by.zemich.order_service.domain.commands.AssignDeliveryDateCommand;
import by.zemich.order_service.domain.events.OrderCreatedEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;

//@Component
public class OrderPersistenceComponent {


    @EventSourcingHandler
    public void on(AssignDeliveryDateCommand event){
        System.out.println(event);
    }

}
