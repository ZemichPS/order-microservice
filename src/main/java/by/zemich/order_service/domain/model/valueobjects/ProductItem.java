package by.zemich.order_service.domain.model.valueobjects;

import by.zemich.order_service.domain.model.entities.Product;
import lombok.Data;

@Data
public class ProductItem {
    private int amount;
    private Product product;
}
