package com.example.sensorlistener.repository.repo_impl.util;

import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.tables.Sensors;
import com.example.sensorlistener.tables.records.SensorsRecord;
import org.jooq.SortField;
import org.jooq.TableField;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JooqRepositoryUtils {
    private JooqRepositoryUtils() {
    }

    public static Sensor fromRecord(SensorsRecord sensorsRecord) {
        return Sensor.builder()
                .id(sensorsRecord.getId())
                .sensorId(sensorsRecord.getSensorName())
                .sensorValue(sensorsRecord.getSensorValue())
                .dateTime(sensorsRecord.getTimestamp())
                .build();
    }

    public static SensorsRecord toRecord(Sensor sensor) {
        SensorsRecord sensorsRecord = new SensorsRecord();
        sensorsRecord.setSensorName(sensor.getSensorId());
        sensorsRecord.setSensorValue(sensor.getSensorValue());
        sensorsRecord.setTimestamp(sensor.getDateTime());
        return sensorsRecord;
    }

    public static List<SensorsRecord> toRecordList(List<Sensor> sensors) {
        return sensors.stream()
                .map(JooqRepositoryUtils::toRecord)
                .toList();
    }

    public static List<Sensor> fromRecordsToList(List<SensorsRecord> sensorsRecords) {
        return sensorsRecords.stream()
                .map(JooqRepositoryUtils::fromRecord)
                .toList();
    }

    public static Collection<SortField<?>> getSortFields(Sort sortSpecification) {
        Collection<SortField<?>> querySortFields = new ArrayList<>();

        if (sortSpecification == null) {
            return querySortFields;
        }

        for (Sort.Order specifiedField : sortSpecification) {
            String sortFieldName = specifiedField.getProperty();
            Sort.Direction sortDirection = specifiedField.getDirection();

            TableField tableField = getTableField(sortFieldName);
            SortField<?> querySortField = convertTableFieldToSortField(tableField, sortDirection);
            querySortFields.add(querySortField);
        }

        return querySortFields;
    }
    private static TableField getTableField(String sortFieldName) {
        TableField sortField;
        try {
            Field tableField = Sensors.SENSORS.getClass().getField(sortFieldName);
            sortField = (TableField) tableField.get(Sensors.SENSORS);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            String errorMessage = String.format("Could not find table field: %s", sortFieldName);
            throw new InvalidDataAccessApiUsageException(errorMessage, ex);
        }

        return sortField;
    }

    private static SortField<?> convertTableFieldToSortField(TableField tableField, Sort.Direction sortDirection) {
        if (sortDirection == Sort.Direction.ASC) {
            return tableField.asc();
        }
        else {
            return tableField.desc();
        }
    }
}
