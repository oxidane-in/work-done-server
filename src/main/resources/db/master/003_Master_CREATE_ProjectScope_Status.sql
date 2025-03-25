-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master_schema;

-- project_status table
CREATE TABLE IF NOT EXISTS master_schema.project_status (
    project_status_id BIGSERIAL PRIMARY KEY,
    project_status_name VARCHAR(50) NOT NULL,
    project_status_handle VARCHAR(50) UNIQUE NOT NULL,
    project_status_desc VARCHAR(255) NULL
);

-- Create project_scope table if it does not exist
CREATE TABLE IF NOT EXISTS master_schema.project_scope (
    project_scope_id BIGSERIAL PRIMARY KEY,
    project_scope_name VARCHAR(100) NOT NULL,
    project_scope_handle VARCHAR(50) UNIQUE NOT NULL,
    project_scope_desc VARCHAR(255) NULL
);
