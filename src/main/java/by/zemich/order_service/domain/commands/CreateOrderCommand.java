package by.zemich.order_service.domain.commands;

import by.zemich.order_service.domain.model.entities.Product;
import by.zemich.order_service.domain.model.valueobjects.ProductItem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class CreateOrderCommand {
    private UUID customerId;
    private String customerName;
    private String customerAddress;
    private List<Product> productList = new ArrayList<>();
}
