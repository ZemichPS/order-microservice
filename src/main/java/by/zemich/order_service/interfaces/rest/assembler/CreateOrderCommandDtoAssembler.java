package by.zemich.order_service.interfaces.rest.assembler;

import by.zemich.order_service.domain.commands.CreateOrderCommand;
import by.zemich.order_service.interfaces.rest.request.NewOrderRequest;

import java.util.UUID;

public class CreateOrderCommandDtoAssembler {
    public static CreateOrderCommand toCommandFromDTO(NewOrderRequest newOrderRequest) {
        return CreateOrderCommand.builder()
                .customerId(newOrderRequest.getCustomerId())
                .customerAddress(newOrderRequest.getCustomerAddress())
                .customerName(newOrderRequest.getCustomerName())
                .productList(newOrderRequest.getProductList())
                .build();
    }
}
