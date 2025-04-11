-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS core_schema;

-- Customer Table
CREATE TABLE IF NOT EXISTS core_schema.customer (
    customer_id BIGSERIAL PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    customer_contact_person VARCHAR(100),
    customer_contact_number VARCHAR(15),
    customer_email VARCHAR(100),
    customer_address TEXT,
    customer_handle VARCHAR(50) UNIQUE NOT NULL,
    customer_desc VARCHAR(255) NULL
);
