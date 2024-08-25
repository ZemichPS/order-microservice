package by.zemich.order_service.domain.model.aggregates;

import by.zemich.order_service.domain.commands.AssignDeliveryDateCommand;
import by.zemich.order_service.domain.commands.CreateOrderCommand;
import by.zemich.order_service.domain.events.DeliveryDateAssignedEvent;
import by.zemich.order_service.domain.events.OrderCreatedEvent;
import by.zemich.order_service.domain.model.entities.Customer;
import by.zemich.order_service.domain.model.entities.Product;
import by.zemich.order_service.domain.model.valueobjects.OrderStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Aggregate
public class Order {

    @AggregateIdentifier
    private UUID orderId;

    private Customer customer;

    private List<Product> productList = new ArrayList<>();

    private LocalDateTime orderDateTime;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;

    protected Order() {
    }


    @CommandHandler
    public Order(CreateOrderCommand command) {
        AggregateLifecycle.apply(new OrderCreatedEvent(
                        UUID.randomUUID(),
                        command.getCustomerId(),
                        command.getCustomerName(),
                        command.getCustomerAddress(),
                        command.getProductList(),
                        LocalDateTime.now(),
                        OrderStatus.NEW
                )
        );
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        orderId = event.getOrderId();
        this.customer = new Customer(event.getCustomerId(),
                event.getCustomerName(),
                event.getCustomerAddress()
        );
        this.productList.addAll(event.getProductList());
        this.orderDateTime = event.getOrderDateTime();
        this.orderStatus = event.getOrderStatus();
    }

    @CommandHandler
    public void assignDeliveryDate(AssignDeliveryDateCommand command) {
        LocalDate assignedDate = command.getDeliveryDate();
        if (assignedDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) throw new RuntimeException("No way!");
        AggregateLifecycle.apply(new DeliveryDateAssignedEvent(
                        command.getOrderId(),
                        command.getDeliveryDate(),
                        OrderStatus.DELIVERY_DATE_ASSIGNED
                )
        );
    }

    @EventSourcingHandler
    public void on(DeliveryDateAssignedEvent event) {
        deliveryDate = event.getDeliveryDate();
        orderStatus = event.getOrderStatus();
    }


}

