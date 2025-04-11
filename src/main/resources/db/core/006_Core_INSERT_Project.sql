-- Insert records into project if they don't exist
INSERT INTO core_schema.project (
    project_code,
    project_name,
    project_location,
    project_city,
    project_state,
    customer_id,
    project_status_id,
    project_scope_id,
    project_secondary_scope_id,
    project_start_date,
    project_end_date_planned,
    project_end_date_actual,
    wo_number,
    wo_date,
    wo_completion_date,
    tenure_of_project_months,
    wo_amount
)
SELECT (
        v.project_code,
        v.project_name,
        v.project_location,
        v.project_city,
        v.project_state,
        v.customer_id,
        v.project_status_id,
        v.project_scope_id,
        v.project_secondary_scope_id,
        v.project_start_date,
        v.project_end_date_planned,
        v.project_end_date_actual,
        v.wo_number,
        v.wo_date,
        v.wo_completion_date,
        v.tenure_of_project_months,
        v.wo_amount
    )
FROM (
    VALUES
        ('PRO0001', 'Skyline Towers', 'MG Road', 'Mumbai', 'Maharashtra', 1, 1, 2, NULL, '2025-01-10', '2025-12-10', NULL, 'WO-20250101', '2025-01-01', NULL, 12, 25000000.00),
        ('PRO0002', 'Green Residency', 'Baner', 'Pune', 'Maharashtra', 2, 1, 3, 5, '2025-02-15', '2025-11-15', NULL, 'WO-20250215', '2025-02-01', NULL, 10, 18000000.00),
        ('PRO0003', 'Blue Horizon', 'Salt Lake', 'Kolkata', 'West Bengal', 3, 2, 4, NULL, '2025-03-20', '2026-03-20', NULL, 'WO-20250320', '2025-03-10', NULL, 12, 32000000.00),
        ('PRO0004', 'Sunrise Heights', 'Whitefield', 'Bangalore', 'Karnataka', 4, 1, 2, NULL, '2025-04-05', '2026-04-05', NULL, 'WO-20250405', '2025-04-01', NULL, 12, 28000000.00),
        ('PRO0005', 'Ocean View', 'Versova', 'Mumbai', 'Maharashtra', 5, 3, 1, 4, '2025-05-12', '2026-05-12', NULL, 'WO-20250512', '2025-05-01', NULL, 12, 35000000.00),
        ('PRO0006', 'Emerald Greens', 'Rajajinagar', 'Bangalore', 'Karnataka', 1, 1, 5, NULL, '2025-06-18', '2026-06-18', NULL, 'WO-20250618', '2025-06-10', NULL, 12, 27000000.00),
        ('PRO0007', 'Golden Nest', 'Anna Nagar', 'Chennai', 'Tamil Nadu', 2, 2, 3, NULL, '2025-07-22', '2026-07-22', NULL, 'WO-20250722', '2025-07-15', NULL, 12, 30000000.00),
        ('PRO0008', 'Maple Woods', 'Sector 62', 'Noida', 'Uttar Pradesh', 3, 1, 4, NULL, '2025-08-10', '2026-08-10', NULL, 'WO-20250810', '2025-08-05', NULL, 12, 26000000.00),
        ('PRO0009', 'Coral Heights', 'Banjara Hills', 'Hyderabad', 'Telangana', 3, 3, 2, 1, '2025-09-30', '2026-09-30', NULL, 'WO-20250930', '2025-09-20', NULL, 12, 40000000.00),
        ('PRO0010', 'Royal Castle', 'Alkapuri', 'Vadodara', 'Gujarat', 5, 2, 5, NULL, '2025-10-15', '2026-10-15', NULL, 'WO-20251015', '2025-10-10', NULL, 12, 31000000.00)
    ) AS v(
        project_code,
        project_name,
        project_location,
        project_city,
        project_state,
        customer_id,
        project_status_id,
        project_scope_id,
        project_secondary_scope_id,
        project_start_date,
        project_end_date_planned,
        project_end_date_actual,
        wo_number,
        wo_date,
        wo_completion_date,
        tenure_of_project_months,
        wo_amount
    )
WHERE NOT EXISTS (
    SELECT 1 FROM core_schema.project p WHERE p.project_code = v.project_code
);
