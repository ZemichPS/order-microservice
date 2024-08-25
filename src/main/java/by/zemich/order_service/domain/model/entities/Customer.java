package by.zemich.order_service.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String address;
}
