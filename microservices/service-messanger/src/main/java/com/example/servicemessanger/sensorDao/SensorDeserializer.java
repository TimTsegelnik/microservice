package com.example.servicemessanger.sensorDao;

import com.example.servicemessanger.domein.Sensor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SensorDeserializer implements Deserializer<SensorData> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public SensorData deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                return null;
            }
            return mapper.readValue(new String(data, UTF_8), SensorData.class);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error when deserializing byte[] to Sensor");
        }
    }
}
