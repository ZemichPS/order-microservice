package by.zemich.order_service.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.config.ConfigurerModule;
import org.axonframework.eventhandling.ErrorHandler;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Log4j2
@Configuration
public class AxonProcessorConfig {
    // omitting other configuration methods...

    @Bean
    public ConfigurerModule segmentCountConfigurerModule(TokenStore tokenStore, ObjectMapper objectMapper) {
        TrackingEventProcessorConfiguration tepConfig =
                TrackingEventProcessorConfiguration
                        .forParallelProcessing(1)
                        .andInitialSegmentsCount(1);

        Serializer serializer = JacksonSerializer.defaultSerializer();

        return configurer -> configurer.eventProcessing(
                processingConfigurer -> processingConfigurer
                        .registerSubscribingEventProcessor(
                                "order-subscribing-event-processor"
                        )
                        .registerTrackingEventProcessorConfiguration("tracking-event-processor", configuration -> tepConfig)
                        .registerTokenStore(configuration -> tokenStore)
                        .registerDefaultErrorHandler(configuration -> (ErrorHandler) errorContext -> log.error("error-processor: {}", errorContext)).registerErrorHandler("tracking-event-processor",
                                configuration -> (ErrorHandler) errorContext -> log.error("error-processor: {}", errorContext)
                        )

        ).configureEventSerializer( configuration -> serializer);
    }

    @Bean
    public TokenStore tokenStore(EntityManagerProvider entityManagerProvider, Serializer serializer) {
        return JpaTokenStore.builder()
                .entityManagerProvider(entityManagerProvider)
                .serializer(serializer)
                .build();
    }


}
