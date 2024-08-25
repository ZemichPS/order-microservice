package by.zemich.order_service.application.internal.commandgateway;

import by.zemich.order_service.domain.commands.AssignDeliveryDateCommand;
import by.zemich.order_service.domain.commands.CreateOrderCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandService {
    private final CommandGateway commandGateway;

    public OrderCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void create(CreateOrderCommand command) {
        commandGateway.send(command);
    }

    public void assignDeliveryDate(AssignDeliveryDateCommand command) {
        commandGateway.send(command);
    }
}
