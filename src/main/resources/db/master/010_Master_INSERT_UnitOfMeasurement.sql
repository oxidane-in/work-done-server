-- Insert sample data into unit_of_measurement only if it doesn't exist
INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Square Meter', 'sqm', 'square_meter', 'Measurement in square meters'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'square_meter'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Cubic Meter', 'm³', 'cubic_meter', 'Measurement in cubic meters'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'cubic_meter'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Linear Meter', 'lm', 'linear_meter', 'Measurement in linear meters'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'linear_meter'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Kilogram', 'kg', 'kilogram', 'Measurement in kilograms'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'kilogram'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Litre', 'l', 'litre', 'Measurement in litres'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'litre'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Ton', 't', 'ton', 'Measurement in metric tons'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'ton'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Feet', 'ft', 'feet', 'Measurement in feet'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'feet'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Inches', 'in', 'inches', 'Measurement in inches'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'inches'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Yard', 'yd', 'yard', 'Measurement in yards'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'yard'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Hectare', 'ha', 'hectare', 'Measurement in hectares'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'hectare'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Acre', 'ac', 'acre', 'Measurement in acres'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'acre'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Millimeter', 'mm', 'millimeter', 'Measurement in millimeters'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'millimeter'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Centimeter', 'cm', 'centimeter', 'Measurement in centimeters'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'centimeter'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Gallon', 'gal', 'gallon', 'Measurement in gallons'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'gallon'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Barrel', 'bbl', 'barrel', 'Measurement in barrels'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'barrel'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Horsepower', 'hp', 'horsepower', 'Measurement in horsepower'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'horsepower'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Newton', 'N', 'newton', 'Measurement in newtons'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'newton'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Joule', 'J', 'joule', 'Measurement in joules'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'joule'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Watt', 'W', 'watt', 'Measurement in watts'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'watt'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Kilowatt', 'kW', 'kilowatt', 'Measurement in kilowatts'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'kilowatt'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Megawatt', 'MW', 'megawatt', 'Measurement in megawatts'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'megawatt'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'GigaWatt', 'GW', 'gigawatt', 'Measurement in gigawatts'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'gigawatt'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Pascal', 'Pa', 'pascal', 'Measurement in pascals'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'pascal'
);

INSERT INTO master.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT 'Celsius', '°C', 'celsius', 'Measurement in degrees Celsius'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.unit_of_measurement WHERE uom_handle = 'celsius'
);
