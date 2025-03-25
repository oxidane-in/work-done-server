-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master_schema;

-- unit_of_measurement table
CREATE TABLE IF NOT EXISTS master_schema.unit_of_measurement (
    uom_id BIGSERIAL PRIMARY KEY,
    uom_name VARCHAR(50) NOT NULL,
    uom_symbol VARCHAR(20),
    uom_handle VARCHAR(50) UNIQUE NOT NULL,
    uom_handle_desc VARCHAR(255) NULL
);
