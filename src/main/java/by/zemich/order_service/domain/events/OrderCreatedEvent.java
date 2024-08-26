package by.zemich.order_service.domain.events;

import by.zemich.order_service.domain.model.entities.Product;
import by.zemich.order_service.domain.model.valueobjects.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class OrderCreatedEvent {
    @TargetAggregateIdentifier
    private UUID orderId;
    private UUID customerId;
    private String customerName;
    private String customerAddress;
    private List<Product> productList;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;
}
