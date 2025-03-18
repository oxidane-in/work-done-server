-- Insert sample data into project_status only if it doesn't exist
INSERT INTO master.project_status (project_status_name, project_status_handle, project_status_desc)
SELECT 'Ongoing', 'ongoing', 'Project is currently in progress'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_status WHERE project_status_handle = 'ongoing'
);

INSERT INTO master.project_status (project_status_name, project_status_handle, project_status_desc)
SELECT 'On hold', 'on_hold', 'Project is temporarily halted'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_status WHERE project_status_handle = 'on_hold'
);

INSERT INTO master.project_status (project_status_name, project_status_handle, project_status_desc)
SELECT 'Completed', 'completed', 'Project has been finished successfully'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_status WHERE project_status_handle = 'completed'
);

INSERT INTO master.project_status (project_status_name, project_status_handle, project_status_desc)
SELECT 'Maintenance', 'maintenance', 'Project is under maintenance phase'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_status WHERE project_status_handle = 'maintenance'
);

-- project_scope table
CREATE TABLE IF NOT EXISTS master.project_scope (
                                                    project_scope_id SERIAL PRIMARY KEY,
                                                    project_scope_name VARCHAR(100) NOT NULL,
    project_scope_handle VARCHAR(50) UNIQUE NOT NULL,
    project_scope_desc VARCHAR(255) NULL,
    project_scope_is_active BOOLEAN DEFAULT TRUE
    );

-- Insert sample data into project_scope only if it doesn't exist
INSERT INTO master.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT 'Basements', 'basements', 'Scope includes all basement areas'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_scope WHERE project_scope_handle = 'basements'
);

INSERT INTO master.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT 'Superstructure', 'superstructure', 'Scope includes all above-ground structures'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_scope WHERE project_scope_handle = 'superstructure'
);

INSERT INTO master.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT 'Podium', 'podium', 'Scope includes podium levels'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_scope WHERE project_scope_handle = 'podium'
);

INSERT INTO master.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT 'Facade', 'facade', 'Scope includes external facade works'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_scope WHERE project_scope_handle = 'facade'
);

INSERT INTO master.project_scope (project_scope_name, project_scope_handle, project_scope_desc)
SELECT 'Roofing', 'roofing', 'Scope includes all roofing-related activities'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.project_scope WHERE project_scope_handle = 'roofing'
);
