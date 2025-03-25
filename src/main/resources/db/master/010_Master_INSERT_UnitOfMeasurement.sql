INSERT INTO master_schema.unit_of_measurement (uom_name, uom_symbol, uom_handle, uom_handle_desc)
SELECT v.uom_name, v.uom_symbol, v.uom_handle, v.uom_handle_desc
FROM (
    VALUES
        ('Square Meter', 'sqm', 'square_meter', 'Measurement in square meters'),
        ('Cubic Meter', 'm³', 'cubic_meter', 'Measurement in cubic meters'),
        ('Linear Meter', 'lm', 'linear_meter', 'Measurement in linear meters'),
        ('Kilogram', 'kg', 'kilogram', 'Measurement in kilograms'),
        ('Litre', 'l', 'litre', 'Measurement in litres'),
        ('Ton', 't', 'ton', 'Measurement in metric tons'),
        ('Feet', 'ft', 'feet', 'Measurement in feet'),
        ('Inches', 'in', 'inches', 'Measurement in inches'),
        ('Yard', 'yd', 'yard', 'Measurement in yards'),
        ('Hectare', 'ha', 'hectare', 'Measurement in hectares'),
        ('Acre', 'ac', 'acre', 'Measurement in acres'),
        ('Millimeter', 'mm', 'millimeter', 'Measurement in millimeters'),
        ('Centimeter', 'cm', 'centimeter', 'Measurement in centimeters'),
        ('Gallon', 'gal', 'gallon', 'Measurement in gallons'),
        ('Barrel', 'bbl', 'barrel', 'Measurement in barrels'),
        ('Horsepower', 'hp', 'horsepower', 'Measurement in horsepower'),
        ('Newton', 'N', 'newton', 'Measurement in newtons'),
        ('Joule', 'J', 'joule', 'Measurement in joules'),
        ('Watt', 'W', 'watt', 'Measurement in watts'),
        ('Kilowatt', 'kW', 'kilowatt', 'Measurement in kilowatts'),
        ('Megawatt', 'MW', 'megawatt', 'Measurement in megawatts'),
        ('GigaWatt', 'GW', 'gigawatt', 'Measurement in gigawatts'),
        ('Pascal', 'Pa', 'pascal', 'Measurement in pascals'),
        ('Celsius', '°C', 'celsius', 'Measurement in degrees Celsius')
) AS v(uom_name, uom_symbol, uom_handle, uom_handle_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM master_schema.unit_of_measurement WHERE uom_handle = v.uom_handle
);
