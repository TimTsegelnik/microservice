package com.example.sensorlistener.repository.repo_impl;


import com.example.sensorlistener.Tables;
import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.repository.SensorRepository;
import com.example.sensorlistener.repository.repo_impl.util.JooqRepositoryUtils;
import com.example.sensorlistener.tables.records.SensorsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.sensorlistener.tables.Sensors.SENSORS;

@Repository
@RequiredArgsConstructor
public class JooqSensorRepositoryImpl implements SensorRepository {

    private final DSLContext jooq;

    @Override
    @Transactional
    public void deleteAllByDateTimeIsBefore(LocalDateTime dateTime) {
        jooq.delete(SENSORS)
                .where(SENSORS.TIMESTAMP.lessOrEqual(dateTime))
                .execute();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sensor> findAllByDateTimeBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith) {
        List<SensorsRecord> sensorsRecords = jooq.selectFrom(SENSORS)
                .where(SENSORS.TIMESTAMP.between(startWith, endWith))
                .orderBy(JooqRepositoryUtils.getSortFields(page.getSort()))
                .limit(page.getPageSize())
                .offset(page.getOffset())
                .fetchInto(SensorsRecord.class);

        return new PageImpl<>(
                JooqRepositoryUtils.fromRecordsToList(sensorsRecords),
                page,
                jooq.fetchCount(Tables.SENSORS)
        );
    }

    @Override
    @Transactional
    public Sensor save(Sensor sensor) {
        SensorsRecord sensorsRecord = jooq.insertInto(Tables.SENSORS)
                .set(JooqRepositoryUtils.toRecord(sensor))
                .returning()
                .fetchOptional()
                .orElseThrow(() -> new DataAccessException("Error inserting entity: " + sensor));

        return JooqRepositoryUtils.fromRecord(sensorsRecord);
    }

    @Override
    @Transactional
    public Iterable<Sensor> saveAll(List<Sensor> sensors) {
        int[] execute = jooq.batchInsert(JooqRepositoryUtils.toRecordList(sensors))
                .execute();

        for (int i = 0; i < execute.length; i++) {
            if (execute[i] == 0){
                throw new DataAccessException("Error inserting entity: " + sensors.get(i));
            }
        }

        return sensors;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sensor> findAll(Pageable page) {
        List<SensorsRecord> sensorsRecords = jooq.selectFrom(SENSORS)
                .orderBy(JooqRepositoryUtils.getSortFields(page.getSort()))
                .limit(page.getPageSize())
                .offset(page.getOffset())
                .fetchInto(SensorsRecord.class);

        return new PageImpl<>(
                JooqRepositoryUtils.fromRecordsToList(sensorsRecords),
                page,
                jooq.fetchCount(Tables.SENSORS)
        );
    }

}
