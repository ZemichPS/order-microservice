package by.zemich.order_service.domain.events;

import by.zemich.order_service.domain.model.aggregates.Order;
import by.zemich.order_service.domain.model.valueobjects.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class DeliveryDateAssignedEvent {
    @TargetAggregateIdentifier
    private UUID orderId;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;
}
