BEGIN;

-- Insert sample data into project_status if they don't exist
INSERT INTO master_schema.project_status (project_status_name, project_status_handle, project_status_desc)
SELECT v.project_status_name,
       v.project_status_handle,
       v.project_status_desc
FROM (
    VALUES
        ('Ongoing', 'ongoing', 'Project is currently in progress'),
        ('On hold', 'on_hold', 'Project is temporarily halted'),
        ('Completed', 'completed', 'Project has been finished successfully'),
        ('Maintenance', 'maintenance', 'Project is under maintenance phase')
) AS v(project_status_name, project_status_handle, project_status_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM master_schema.project_status ps
    WHERE ps.project_status_handle = v.project_status_handle
);

-- Insert sample data into project_scope if they don't exist
INSERT INTO master_schema.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT v.project_scope_name,
       v.project_scope_handle,
       v.project_scope_desc
FROM (
    VALUES
        ('Basements', 'basements', 'Scope includes all basement areas'),
        ('Superstructure', 'superstructure', 'Scope includes all above-ground structures'),
        ('Podium', 'podium', 'Scope includes podium levels'),
        ('Facade', 'facade', 'Scope includes external facade works'),
        ('Roofing', 'roofing', 'Scope includes all roofing-related activities')
) AS v(project_scope_name, project_scope_handle, project_scope_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM master_schema.project_scope ps
    WHERE ps.project_scope_handle = v.project_scope_handle
);

COMMIT;
