-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS core_schema;

-- Worker Table
CREATE TABLE core_schema.worker (
    worker_id BIGSERIAL PRIMARY KEY,
    worker_code VARCHAR(50) NOT NULL UNIQUE,
    worker_name VARCHAR(255) NOT NULL,
    worker_type_id BIGINT NOT NULL,
    rate DECIMAL(10,2) NOT NULL,
    bank_account VARCHAR(20) NOT NULL UNIQUE,
    ifsc VARCHAR(11) NOT NULL,
    birth_date DATE NOT NULL,
    mobile_number VARCHAR(15) NOT NULL UNIQUE,
    state VARCHAR(100) NOT NULL,
    joining_date DATE NOT NULL,

    CONSTRAINT fk_worker_type FOREIGN KEY (worker_type_id)
        REFERENCES master_schema.worker_type(worker_type_id) ON DELETE CASCADE
);
