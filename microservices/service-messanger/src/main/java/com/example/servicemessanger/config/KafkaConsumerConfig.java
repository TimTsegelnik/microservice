package com.example.servicemessanger.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerConfig {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServer;
//
//    @Bean
//    public Map<String, Object> consumerConfig() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
//        props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(DELE)
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, SensorData> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfig());
//    }
//
//    @Bean
//    public KafkaListenerContainerFactory
//            <ConcurrentMessageListenerContainer<String, SensorData>> kafkaListenerSensorFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, SensorData> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
}
