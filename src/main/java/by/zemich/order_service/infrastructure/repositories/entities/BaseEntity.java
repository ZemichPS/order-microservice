package by.zemich.order_service.infrastructure.repositories.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

    @MappedSuperclass
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class BaseEntity {
        @Id
        private UUID uuid;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private boolean deleted;
    }
