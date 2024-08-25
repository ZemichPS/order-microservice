package by.zemich.order_service.interfaces.rest;

import by.zemich.order_service.application.internal.commandgateway.OrderCommandService;
import by.zemich.order_service.domain.commands.AssignDeliveryDateCommand;
import by.zemich.order_service.domain.commands.CreateOrderCommand;
import by.zemich.order_service.interfaces.rest.assembler.CreateOrderCommandDtoAssembler;
import by.zemich.order_service.interfaces.rest.request.NewOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderCommandService commandService;

    public OrderController(OrderCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody NewOrderRequest request) {
        CreateOrderCommand command = CreateOrderCommandDtoAssembler.toCommandFromDTO(request);
        commandService.create(command);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    private ResponseEntity<Void> test(@RequestParam String uuid) {
        commandService.assignDeliveryDate(AssignDeliveryDateCommand.builder()
                .orderId(UUID.fromString(uuid))
                .deliveryDate(LocalDate.now())
                .build());
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
