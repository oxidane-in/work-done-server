-- Insert sample data into unit_type only if it doesn't exist
INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Common Toilet', 'common_toilet', 'Shared toilet for multiple users'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'common_toilet'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Master Toilet', 'master_toilet', 'Private toilet in master bedroom'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'master_toilet'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Kitchen', 'kitchen', 'Space used for cooking and food preparation'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'kitchen'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Living Room', 'living_room', 'Common living area'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'living_room'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Balcony', 'balcony', 'Outdoor space attached to a unit'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'balcony'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Bedroom', 'bedroom', 'Room for sleeping'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'bedroom'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Storage Room', 'storage_room', 'Space for storing items'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'storage_room'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Lobby', 'lobby', 'Common area for waiting or movement'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'lobby'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Staircase', 'staircase', 'Structure for vertical movement between floors'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'staircase'
);

INSERT INTO master.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT 'Parking', 'parking', 'Dedicated space for vehicle parking'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_type WHERE unit_type_handle = 'parking'
);
