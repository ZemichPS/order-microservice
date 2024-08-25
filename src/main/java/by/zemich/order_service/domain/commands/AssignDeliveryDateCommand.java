package by.zemich.order_service.domain.commands;

import by.zemich.order_service.domain.model.valueobjects.OrderStatus;
import lombok.*;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class AssignDeliveryDateCommand {
    @TargetAggregateIdentifier
    private UUID orderId;
    private LocalDate deliveryDate;
}
