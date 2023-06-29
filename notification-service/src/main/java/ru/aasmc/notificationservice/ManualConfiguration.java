package ru.aasmc.notificationservice;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class ManualConfiguration {
    private final ConcurrentKafkaListenerContainerFactory factory;

    @PostConstruct
    void setup() {
        this.factory.getContainerProperties()
                .setObservationEnabled(true);
    }
}
