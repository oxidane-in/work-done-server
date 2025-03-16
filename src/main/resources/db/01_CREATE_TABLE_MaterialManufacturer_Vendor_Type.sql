CREATE TABLE IF NOT EXISTS work_done_dbo.material_manufacturer (
    material_manufacturer_id INT PRIMARY KEY NOT NULL,
    material_manufacturer_name VARCHAR(255) NOT NULL,
    material_manufacturer_desc VARCHAR(255) NULL,
    material_manufacturer_handle VARCHAR(255) NULL
);
CREATE TABLE IF NOT EXISTS work_done_dbo.material_vendor (
    material_vendor_id INT PRIMARY KEY NOT NULL,
    material_vendor_name VARCHAR(255) NOT NULL,
    material_vendor_desc VARCHAR(255) NULL,
    material_vendor_handle VARCHAR(255) NULL
);
CREATE TABLE IF NOT EXISTS work_done_dbo.material_type (
    material_type_id INT PRIMARY KEY NOT NULL,
    material_type_name VARCHAR(255) NOT NULL,
    material_type_desc VARCHAR(255) NULL,
    material_type_handle VARCHAR(255) NULL
);