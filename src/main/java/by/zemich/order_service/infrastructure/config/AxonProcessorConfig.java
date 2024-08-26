package by.zemich.order_service.infrastructure.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.config.ConfigurerModule;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonProcessorConfig {
    // omitting other configuration methods...

    @Bean
    public ConfigurerModule segmentCountConfigurerModule(TokenStore tokenStore) {
        TrackingEventProcessorConfiguration tepConfig =
                TrackingEventProcessorConfiguration
                        .forParallelProcessing(1)
                        .andInitialSegmentsCount(1);

        return configurer -> configurer.eventProcessing(
                processingConfigurer -> processingConfigurer
                        .registerSubscribingEventProcessor(
                                "order-service-processor"
                        )
                        .registerTrackingEventProcessorConfiguration("tracking-event-processor", configuration -> tepConfig)
                        .registerTokenStore(configuration -> tokenStore)
        );
    }


    @Bean
    public TokenStore tokenStore(EntityManagerProvider entityManagerProvider, Serializer serializer) {
        return JpaTokenStore.builder()
                .entityManagerProvider(entityManagerProvider)
                .serializer(serializer)
                .build();
    }

}
