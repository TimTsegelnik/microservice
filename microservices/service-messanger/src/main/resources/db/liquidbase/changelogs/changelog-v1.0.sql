--liquibase formatted sql

--changeset Admin:1.0
CREATE SEQUENCE sensor_seq as int8 start 10;

--changeset Admin:1.1
CREATE TABLE SENSOR
(
    id          serial                      not null,
    sensor_name varchar(50)                 not null,
    sensor_data int4                        not null,
    timestamp   timestamp without time zone not null,
    primary key (id)
);

