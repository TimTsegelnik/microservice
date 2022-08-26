package com.example.auditservice.repository;

import com.example.auditservice.TestSensorsExamples;
import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;


    @Sql("classpath:db/test/populate.sql")
    @Sql(scripts = "classpath:db/test/clean-up.sql", executionPhase = AFTER_TEST_METHOD)
    @ParameterizedTest
    @MethodSource("com.example.auditservice.domein.SensorStatus#values")
    void should_find_by_status_normal(SensorStatus status) {

        Page<Sensor> allByStatusIsNormal = sensorRepository.findAllByStatusIs(Pageable.unpaged(), status);

        assertThat(allByStatusIsNormal.getContent())
                .containsAnyElementsOf(TestSensorsExamples.getPopulatedSensors());

    }

}