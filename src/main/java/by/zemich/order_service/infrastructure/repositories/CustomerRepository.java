package by.zemich.order_service.infrastructure.repositories;

import by.zemich.order_service.infrastructure.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
