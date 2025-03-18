-- Insert materials if they don't exist
DO $$
DECLARE
    material_exists BOOLEAN;
BEGIN
    -- Check if material #1 exists (as a sample check)
    SELECT EXISTS (
        SELECT 1 FROM core.material WHERE material_id = 1
    ) INTO material_exists;

    -- Only proceed with inserts if materials don't exist
    IF NOT material_exists THEN
        -- Insert waterproofing materials
        INSERT INTO core.material (
                material_id,
                material_name,
                material_manufacturer_id,
                material_vendor_id,
                material_type_id,
                material_unit,
                material_pack_size,
                material_rate_per_pack
        )
        VALUES 
            (1, 'Acrylic Waterproofing Coating', 1, 2, 2, 'Liters', 20.00, 5000.00),
            (2, 'Bitumen Waterproofing Membrane', 2, 3, 2, 'Roll', 10.00, 7000.00),
            (3, 'Cementitious Waterproofing Coating', 3, 4, 2, 'Kg', 25.00, 3500.00),
            (4, 'Polyurethane Waterproofing Coating', 4, 5, 2, 'Liters', 15.00, 8000.00),
            (5, 'Epoxy Waterproofing Resin', 5, 6, 2, 'Kg', 10.00, 6000.00),
            (6, 'Silicone-based Waterproofing Spray', 6, 7, 2, 'Liters', 5.00, 3000.00),
            (7, 'Elastomeric Waterproofing Coating', 7, 8, 2, 'Liters', 18.00, 7500.00),
            (8, 'Crystalline Waterproofing Admixture', 8, 9, 2, 'Kg', 20.00, 4000.00),
            (9, 'Self-Adhesive Waterproofing Membrane', 9, 10, 2, 'Roll', 12.00, 8500.00),
            (10, 'SBR Waterproofing Latex', 10, 1, 2, 'Liters', 20.00, 5500.00),
            (11, 'Hydrophobic Concrete Admixture', 1, 2, 2, 'Kg', 15.00, 6200.00),
            (12, 'Liquid Rubber Waterproofing', 2, 3, 2, 'Liters', 25.00, 9000.00),
            (13, 'Flexible Cementitious Waterproofing', 3, 4, 2, 'Kg', 20.00, 4100.00),
            (14, 'Tar-based Waterproofing Coating', 4, 5, 2, 'Liters', 10.00, 4500.00),
            (15, 'Waterproofing Polymer Mortar', 5, 6, 2, 'Kg', 30.00, 8000.00),
            (16, 'Nano-coating Waterproofing', 6, 7, 2, 'Liters', 8.00, 7200.00),
            (17, 'Waterproofing Bitumen Tape', 7, 8, 2, 'Roll', 5.00, 5000.00),
            (18, 'Water Repellent Coating', 8, 9, 2, 'Liters', 18.00, 4300.00),
            (19, 'Polymer Modified Cementitious Coating', 9, 10, 2, 'Kg', 22.00, 6700.00),
            (20, 'UV Resistant Waterproofing Coating', 10, 1, 2, 'Liters', 12.00, 7800.00),
            (21, 'High-Build Waterproofing Coating', 1, 2, 2, 'Kg', 25.00, 5200.00),
            (22, 'Two-component Waterproofing Mortar', 2, 3, 2, 'Kg', 20.00, 6900.00),
            (23, 'Cold Applied Waterproofing Membrane', 3, 4, 2, 'Roll', 8.00, 5500.00),
            (24, 'Waterproofing Emulsion Paint', 4, 5, 2, 'Liters', 15.00, 4600.00),
            (25, 'Breathable Waterproofing Coating', 5, 6, 2, 'Liters', 22.00, 8200.00),
            (26, 'Tar Epoxy Waterproofing', 6, 7, 2, 'Liters', 10.00, 6100.00),
            (27, 'Hybrid Waterproofing Polymer', 7, 8, 2, 'Kg', 30.00, 7500.00),
            (28, 'Deep Penetrating Waterproofing Sealer', 8, 9, 2, 'Liters', 5.00, 3000.00),
            (29, 'Transparent Waterproofing Coating', 9, 10, 2, 'Liters', 12.00, 5300.00),
            (30, 'Reflective Waterproofing Paint', 10, 1, 2, 'Liters', 18.00, 7000.00),
            (31, 'Waterproofing Cement Additive', 1, 2, 2, 'Kg', 10.00, 3500.00),
            (32, 'Moisture Resistant Waterproofing Paint', 2, 3, 2, 'Liters', 20.00, 5400.00),
            (33, 'Basement Waterproofing System', 3, 4, 2, 'Kg', 18.00, 6300.00),
            (34, 'Weatherproof Waterproofing Coating', 4, 5, 2, 'Liters', 25.00, 8500.00),
            (35, 'Seamless Waterproofing Coating', 5, 6, 2, 'Liters', 8.00, 4200.00),
            (36, 'Waterproofing Grout', 6, 7, 2, 'Kg', 12.00, 3900.00),
            (37, 'Expanding Waterproofing Foam', 7, 8, 2, 'Liters', 15.00, 7200.00),
            (38, 'Elastic Waterproofing Sheet', 8, 9, 2, 'Roll', 10.00, 6500.00),
            (39, 'Advanced Waterproofing Hybrid', 9, 10, 2, 'Liters', 20.00, 7900.00),
            (40, 'High-performance Waterproofing Spray', 10, 1, 2, 'Liters', 12.00, 6800.00),
            (41, 'Adhesive Waterproofing Membrane', 1, 2, 2, 'Roll', 8.00, 5500.00),
            (42, 'Waterproofing Protective Coating', 2, 3, 2, 'Liters', 22.00, 6100.00),
            (43, 'Fiber Reinforced Waterproofing', 3, 4, 2, 'Kg', 15.00, 7200.00),
            (44, 'Ultra Flexible Waterproofing Coating', 4, 5, 2, 'Liters', 18.00, 6800.00),
            (45, 'Under Tile Waterproofing Membrane', 5, 6, 2, 'Roll', 10.00, 7400.00),
            (46, 'External Waterproofing Primer', 6, 7, 2, 'Liters', 20.00, 5100.00),
            (47, 'Cavity Waterproofing Compound', 7, 8, 2, 'Kg', 25.00, 6000.00),
            (48, 'Hybrid Silicone Waterproofing', 8, 9, 2, 'Liters', 12.00, 5800.00),
            (49, 'Corrosion-resistant Waterproofing', 9, 10, 2, 'Liters', 15.00, 7200.00),
            (50, 'Multi-purpose Waterproofing Sealant', 10, 1, 2, 'Liters', 18.00, 7500.00);
    END IF;
END
$$; 