package by.zemich.order_service.infrastructure.config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AxonStorageConfig {

//
//    @Bean
//    protected EntityManager entityManager(EntityManagerFactory emf) {
//        return emf.createEntityManager();
//    }
//
//    @Bean
//    protected EntityManagerProvider entityManagerProvider(EntityManager entityManager) {
//        return new SimpleEntityManagerProvider(entityManager);
//    }
//
//    @Bean(name = "axonTransactionManager")
//    TransactionManager transactionManager(PlatformTransactionManager platformTransactionManager) {
//        return new SpringTransactionManager(platformTransactionManager);
//    }
//
//    @Bean
//    protected EventStorageEngine eventStorageEngine(EntityManagerProvider entityManagerProvider, TransactionManager transactionManager) {
//        return JpaEventStorageEngine.builder()
//                .entityManagerProvider(entityManagerProvider)
//                .transactionManager(transactionManager)
//                .build();
//    }
//
//
//
//    @Bean
//    protected EventStore eventStore(EventStorageEngine eventStorageEngine) {
//        return EmbeddedEventStore.builder()
//                .storageEngine(eventStorageEngine)
//                .build();
//    }
}
