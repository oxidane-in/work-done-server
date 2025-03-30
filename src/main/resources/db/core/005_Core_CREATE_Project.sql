-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS core_schema;

-- Project Table
CREATE TABLE IF NOT EXISTS core_schema.project (
    project_id BIGSERIAL PRIMARY KEY,
    project_code VARCHAR(50) NOT NULL UNIQUE,
    project_name VARCHAR(255) NOT NULL,
    project_location VARCHAR(255) NOT NULL,
    project_city VARCHAR(100) NOT NULL,
    project_state VARCHAR(100) NOT NULL,
    customer_id BIGINT NOT NULL,
    project_status_id BIGINT NOT NULL,
    project_start_date DATE NOT NULL,
    project_end_date_planned DATE NOT NULL,
    project_end_date_actual DATE NULL,
    wo_number VARCHAR(50) NOT NULL UNIQUE,
    wo_date DATE NOT NULL,
    wo_completion_date DATE NULL,
    tenure_of_project_months INT NOT NULL,
    wo_amount DECIMAL(18,2) NOT NULL,

    CONSTRAINT fk_project_customer FOREIGN KEY (customer_id)
        REFERENCES core_schema.customer(customer_id) ON DELETE CASCADE,
    CONSTRAINT fk_project_status FOREIGN KEY (project_status_id)
        REFERENCES master_schema.project_status(project_status_id) ON DELETE CASCADE
);
