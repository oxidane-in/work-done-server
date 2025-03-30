BEGIN;

INSERT INTO master_schema.unit_type (unit_type_name, unit_type_handle, unit_type_desc)
SELECT v.unit_type_name, v.unit_type_handle, v.unit_type_desc
FROM (
    VALUES
        ('Common Toilet', 'common_toilet', 'Shared toilet for multiple users'),
        ('master_schema Toilet', 'master_schema_toilet', 'Private toilet in master_schema bedroom'),
        ('Kitchen', 'kitchen', 'Space used for cooking and food preparation'),
        ('Living Room', 'living_room', 'Common living area'),
        ('Balcony', 'balcony', 'Outdoor space attached to a unit'),
        ('Bedroom', 'bedroom', 'Room for sleeping'),
        ('Storage Room', 'storage_room', 'Space for storing items'),
        ('Lobby', 'lobby', 'Common area for waiting or movement'),
        ('Staircase', 'staircase', 'Structure for vertical movement between floors'),
        ('Parking', 'parking', 'Dedicated space for vehicle parking')
) AS v(unit_type_name, unit_type_handle, unit_type_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM master_schema.unit_type WHERE unit_type_handle = v.unit_type_handle
);

COMMIT;
