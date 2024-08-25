package by.zemich.order_service.interfaces.rest.request;

import by.zemich.order_service.domain.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderRequest {
    private UUID customerId;
    private String customerName;
    private String customerAddress;
    private List<Product> productList;
}
