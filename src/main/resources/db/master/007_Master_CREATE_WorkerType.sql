-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master_schema;

-- worker_type table
CREATE TABLE IF NOT EXISTS master_schema.worker_type (
    worker_type_id BIGSERIAL PRIMARY KEY,
    worker_type_name VARCHAR(90) NOT NULL,
    worker_type_rate DECIMAL(10,2) NOT NULL,
    worker_type_handle VARCHAR(100) UNIQUE NOT NULL,
    worker_type_desc VARCHAR(255) NULL
);
