--liquibase formatted sql

--changeset Admin:1.0
CREATE TABLE IF NOT EXISTS sensors
(
    id           SERIAL                      NOT NULL,
    sensor_name  VARCHAR(50)                 NOT NULL,
    sensor_value INT4                        NOT NULL,
    timestamp    TIMESTAMP WITHOUT TIME ZONE NOT NULL
) PARTITION BY HASH (id);

--changeset Admin:1.1
CREATE TABLE IF NOT EXISTS sensors_hash_part_0_of_4 PARTITION OF sensors FOR VALUES WITH (MODULUS 4, REMAINDER 0);

--changeset Admin:1.2
CREATE TABLE IF NOT EXISTS sensors_hash_part_1_of_4 PARTITION OF sensors FOR VALUES WITH (MODULUS 4, REMAINDER 1);

--changeset Admin:1.3
CREATE TABLE IF NOT EXISTS sensors_hash_part_2_of_4 PARTITION OF sensors FOR VALUES WITH (MODULUS 4, REMAINDER 2);

--changeset Admin:1.4
CREATE TABLE IF NOT EXISTS sensors_hash_part_3_of_4 PARTITION OF sensors FOR VALUES WITH (MODULUS 4, REMAINDER 3);


