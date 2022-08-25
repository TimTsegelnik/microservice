--liquibase formatted sql

--changeset Tsegelnik:1.0
CREATE SEQUENCE sensor_seq as int8;

--changeset Tsegelnik:1.1
CREATE TABLE SENSOR
(
    id          serial                      not null,
    sensor_name varchar(50)                 not null,
    sensor_data int4                        not null,
    timestamp   timestamp without time zone not null,
    status      varchar(50)                 not null,
    primary key (id, status)
) PARTITION BY LIST (status);

--changeset Tsegelnik:1.2
CREATE TABLE SENSOR_NORMAL PARTITION OF SENSOR FOR VALUES IN ('NORMAL');

--changeset Tsegelnik:1.3
CREATE TABLE SENSOR_LOADED PARTITION OF SENSOR FOR VALUES IN ('LOADED');

--changeset Tsegelnik:1.4
CREATE TABLE SENSOR_FAILED PARTITION OF SENSOR FOR VALUES IN ('FAILED');

--changeset Tsegelnik:1.5
CREATE OR REPLACE FUNCTION sensor_insert_trigger()
    RETURNS TRIGGER AS
'
    BEGIN
        IF (NEW.status = ''NORMAL'')
        THEN
            INSERT INTO SENSOR_NORMAL VALUES (NEW.*);
        ELSIF (NEW.status = ''LOADED'')
        THEN
            INSERT INTO SENSOR_LOADED VALUES (NEW.*);
        ELSIF (NEW.status = ''FAILED'')
        THEN
            INSERT INTO SENSOR_FAILED VALUES (NEW.*);
        ELSE
            RAISE EXCEPTION ''STATUS is incorrect'';
        END IF;
        RETURN NULL;
    END;
'
    LANGUAGE plpgsql;

--changeset Tsegelnik:1.6
CREATE TRIGGER insert_measurement_trigger
    BEFORE INSERT OR UPDATE
    ON SENSOR
    FOR EACH ROW
    WHEN ( pg_trigger_depth() = 0)
EXECUTE PROCEDURE sensor_insert_trigger();
