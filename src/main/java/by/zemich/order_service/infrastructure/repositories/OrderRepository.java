package by.zemich.order_service.infrastructure.repositories;

import by.zemich.order_service.infrastructure.repositories.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
