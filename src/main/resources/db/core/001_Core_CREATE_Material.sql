-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS core;

-- material table
CREATE TABLE IF NOT EXISTS core.material (
    material_id INT PRIMARY KEY,
    material_name VARCHAR(255) NOT NULL,
    material_manufacturer_id INT NULL,
    material_vendor_id INT NULL,
    material_type_id INT NULL,
    material_unit VARCHAR(50),
    material_pack_size DECIMAL(10, 2) NOT NULL CHECK (material_pack_size > 0),
    material_rate_per_pack DECIMAL(10, 2) CHECK (material_rate_per_pack >= 0),
    material_rate_per_unit DECIMAL(10, 2) GENERATED ALWAYS AS (material_rate_per_pack / material_pack_size) STORED,
    CONSTRAINT fk_material_manufacturer FOREIGN KEY (material_manufacturer_id) REFERENCES master.material_manufacturer(material_manufacturer_id),
    CONSTRAINT fk_material_vendor FOREIGN KEY (material_vendor_id) REFERENCES master.material_vendor(material_vendor_id),
    CONSTRAINT fk_material_type FOREIGN KEY (material_type_id) REFERENCES master.material_type(material_type_id)
);
