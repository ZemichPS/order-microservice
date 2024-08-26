package by.zemich.order_service.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonJacksonConfig {
    @Bean
    public Serializer serializer(ObjectMapper objectMapper) {
        return JacksonSerializer.builder()
                .objectMapper(objectMapper)
                .build();
    }
}
