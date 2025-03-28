CREATE SCHEMA IF NOT EXISTS mdm_schema;

-- TODO: Add audit fields - created_by, created_on, updated_by, updated_on

CREATE TABLE mdm_schema.unit_of_measurement
(
    uom_id          BIGSERIAL PRIMARY KEY,
    uom_name        VARCHAR(50) UNIQUE NOT NULL,
    uom_symbol      VARCHAR(20) UNIQUE,
    uom_handle      VARCHAR(50) UNIQUE NOT NULL,
    uom_handle_desc VARCHAR(255)
);
