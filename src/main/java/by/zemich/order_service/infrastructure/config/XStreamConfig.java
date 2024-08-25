package by.zemich.order_service.infrastructure.config;


import by.zemich.order_service.domain.events.DeliveryDateAssignedEvent;
import by.zemich.order_service.domain.events.OrderCreatedEvent;
import by.zemich.order_service.domain.model.entities.Product;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class XStreamConfig {

    @Bean
    @Primary
    public XStreamSerializer xStreamSerializer() {
        XStream xStream = createSecureXStream();
        return XStreamSerializer.builder()
                .xStream(xStream)
                .build();
    }

    private XStream createSecureXStream() {
        XStream xStream = new XStream();
        xStream.addPermission(new WildcardTypePermission(
                new String[]{
                        "by.zemich.order_service.domain.*"
                })
        );
        xStream.allowTypes(new Class[]{
                OrderCreatedEvent.class,
                Product.class,
                DeliveryDateAssignedEvent.class
        });

        return xStream;
    }

}
