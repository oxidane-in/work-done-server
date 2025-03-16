-- Insert records into material_manufacturer if they don't exist
INSERT INTO work_done_dbo.material_manufacturer (
        material_manufacturer_id,
        material_manufacturer_name,
        material_manufacturer_desc,
        material_manufacturer_handle
    )
SELECT *
FROM (
        VALUES (
                1,
                'ABC Chemicals',
                'Leading chemical supplier',
                'abc_chem'
            ),
            (
                2,
                'XYZ Builders',
                'Construction material provider',
                'xyz_build'
            ),
            (
                3,
                'Global Materials',
                'Global distributor of raw materials',
                'global_mat'
            ),
            (
                4,
                'Eco Green Solutions',
                'Eco-friendly material manufacturer',
                'eco_green'
            ),
            (
                5,
                'IronWorks Ltd.',
                'Iron and steel manufacturer',
                'iron_works'
            ),
            (
                6,
                'PlastiCo',
                'Plastic and polymer manufacturer',
                'plasti_co'
            ),
            (7, 'CementX', 'Top cement supplier', 'cement_x'),
            (
                8,
                'TimberCorp',
                'High-quality wood supplier',
                'timber_corp'
            ),
            (
                9,
                'SteelMakers',
                'Steel product manufacturer',
                'steel_makers'
            ),
            (
                10,
                'NanoTech Materials',
                'Advanced material research and production',
                'nano_tech'
            )
    ) AS new_values
WHERE NOT EXISTS (
        SELECT 1
        FROM work_done_dbo.material_manufacturer
        WHERE material_manufacturer_id = new_values.column1
    );
-- Insert records into material_vendor if they don't exist
INSERT INTO work_done_dbo.material_vendor (
        material_vendor_id,
        material_vendor_name,
        material_vendor_desc,
        material_vendor_handle
    )
SELECT *
FROM (
        VALUES (
                1,
                'Vendor A',
                'Wholesale material supplier',
                'vendor_a'
            ),
            (
                2,
                'Vendor B',
                'Industrial material distributor',
                'vendor_b'
            ),
            (
                3,
                'Vendor C',
                'Local material provider',
                'vendor_c'
            ),
            (4, 'Vendor D', 'Eco-friendly vendor', 'vendor_d'),
            (5, 'Vendor E', 'Specialty materials', 'vendor_e'),
            (
                6,
                'Vendor F',
                'Chemicals and solvents supplier',
                'vendor_f'
            ),
            (
                7,
                'Vendor G',
                'Infrastructure materials',
                'vendor_g'
            ),
            (
                8,
                'Vendor H',
                'Bulk construction materials',
                'vendor_h'
            ),
            (9, 'Vendor I', 'Small-scale vendor', 'vendor_i'),
            (
                10,
                'Vendor J',
                'Custom material solutions',
                'vendor_j'
            )
    ) AS new_values
WHERE NOT EXISTS (
        SELECT 1
        FROM work_done_dbo.material_vendor
        WHERE material_vendor_id = new_values.column1
    );
-- Insert records into material_type if they don't exist
INSERT INTO work_done_dbo.material_type (
        material_type_id,
        material_type_name,
        material_type_desc,
        material_type_handle
    )
SELECT *
FROM (
        VALUES (
                1,
                'Building Material',
                'Materials used in construction',
                'build_mat'
            ),
            (
                2,
                'Chemical Material',
                'Chemical-based materials and solutions',
                'chem_mat'
            ),
            (
                3,
                'Others',
                'Miscellaneous materials',
                'other_mat'
            )
    ) AS new_values
WHERE NOT EXISTS (
        SELECT 1
        FROM work_done_dbo.material_type
        WHERE material_type_id = new_values.column1
    );