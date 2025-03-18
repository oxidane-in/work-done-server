-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master;

-- worker_type table
CREATE TABLE IF NOT EXISTS master.worker_type (
    worker_type_id SERIAL PRIMARY KEY,
    worker_type_name VARCHAR(50) NOT NULL,
    worker_type_rate DECIMAL(10,2) NOT NULL,
    worker_type_handle VARCHAR(50) UNIQUE NOT NULL,
    worker_type_desc VARCHAR(255) NULL,
    worker_type_is_active BOOLEAN DEFAULT TRUE
);
