package com.example.sensor.sensorDao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class SensorSerializer implements Serializer<SensorData> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, SensorData data) {
        try {
            if (data == null) {
                return null;
            }
            return mapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing SensorData to byte[]", e);
        }

    }
}
