-- liquibase formatted sql

--changeset Tsegelnik:id1
CREATE TABLE SENSOR
(
    ID          SERIAL PRIMARY KEY,
    SENSOR_ID   varchar(50) not null,
    SENSOR_DATA int4        not null,
    DATE_TIME   timestamp   not null,
    STATUS      VARCHAR(50) not null
);