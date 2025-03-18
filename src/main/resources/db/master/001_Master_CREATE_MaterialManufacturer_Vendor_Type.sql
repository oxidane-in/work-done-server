-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS master;

-- material_manufacturer table
CREATE TABLE IF NOT EXISTS core.material_manufacturer (
    material_manufacturer_id INT PRIMARY KEY NOT NULL,
    material_manufacturer_name VARCHAR(255) NOT NULL,
    material_manufacturer_desc VARCHAR(255) NULL,
    material_manufacturer_handle VARCHAR(255) NULL
);

-- material_vendor table
CREATE TABLE IF NOT EXISTS core.material_vendor (
    material_vendor_id INT PRIMARY KEY NOT NULL,
    material_vendor_name VARCHAR(255) NOT NULL,
    material_vendor_desc VARCHAR(255) NULL,
    material_vendor_handle VARCHAR(255) NULL
);

-- material_type table
CREATE TABLE IF NOT EXISTS core.material_type (
    material_type_id INT PRIMARY KEY NOT NULL,
    material_type_name VARCHAR(255) NOT NULL,
    material_type_desc VARCHAR(255) NULL,
    material_type_handle VARCHAR(255) NULL
);
