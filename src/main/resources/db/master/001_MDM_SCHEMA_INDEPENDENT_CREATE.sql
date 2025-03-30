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

CREATE TABLE mdm_schema.worker_type
(
    worker_type_id     BIGSERIAL PRIMARY KEY,
    worker_type_name   VARCHAR(50) UNIQUE NOT NULL,
    worker_type_rate   DECIMAL(10, 2)     NOT NULL,
    worker_type_handle VARCHAR(50) UNIQUE NOT NULL,
    worker_type_desc   VARCHAR(255)
);

CREATE TABLE mdm_schema.project_scope
(
    project_scope_id     BIGSERIAL PRIMARY KEY,
    project_scope_name   VARCHAR(100) UNIQUE NOT NULL,
    project_scope_handle VARCHAR(100) UNIQUE NOT NULL,
    project_scope_desc   VARCHAR(255)
);

CREATE TABLE mdm_schema.project_status
(
    project_status_id     BIGSERIAL PRIMARY KEY,
    project_status_name   VARCHAR(50) UNIQUE NOT NULL,
    project_status_handle VARCHAR(50) UNIQUE NOT NULL,
    project_status_desc   VARCHAR(255)
);

CREATE TABLE mdm_schema.material_manufacturer
(
    material_manufacturer_id     BIGSERIAL PRIMARY KEY,
    material_manufacturer_name   VARCHAR(255) UNIQUE NOT NULL,
    material_manufacturer_desc   VARCHAR(255),
    material_manufacturer_handle VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE mdm_schema.material_type
(
    material_type_id     BIGSERIAL PRIMARY KEY,
    material_type_name   VARCHAR(255) UNIQUE NOT NULL,
    material_type_desc   VARCHAR(255),
    material_type_handle VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE mdm_schema.material_vendor
(
    material_vendor_id     BIGSERIAL PRIMARY KEY,
    material_vendor_name   VARCHAR(255) UNIQUE NOT NULL,
    material_vendor_desc   VARCHAR(255),
    material_vendor_handle VARCHAR(255) UNIQUE NOT NULL
);
