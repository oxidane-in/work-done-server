-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master_schema;

-- unit_type table
CREATE TABLE IF NOT EXISTS master_schema.unit_type (
    unit_type_id BIGSERIAL PRIMARY KEY,
    unit_type_name VARCHAR(100) NOT NULL,
    unit_type_handle VARCHAR(50) UNIQUE NOT NULL,
    unit_type_desc VARCHAR(255) NULL
);
