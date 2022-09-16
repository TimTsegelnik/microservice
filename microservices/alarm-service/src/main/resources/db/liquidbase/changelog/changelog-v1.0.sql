--liquibase formatted sql

--changeset Admin:1.0
CREATE TABLE IF NOT EXISTS sensor
(
    id           SERIAL                      NOT NULL,
    sensor_name  VARCHAR(50)                 NOT NULL,
    sensor_value INT4                        NOT NULL,
    timestamp    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY (id)
);