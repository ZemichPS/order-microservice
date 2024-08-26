package by.zemich.order_service.infrastructure.repositories.entities;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer", referencedColumnName = "uuid")
    private CustomerEntity customer;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Product> productList;

}

@Data
@NoArgsConstructor
class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int quantity;
}