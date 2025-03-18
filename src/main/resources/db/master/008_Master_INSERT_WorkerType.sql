-- Insert sample data into worker_type only if it doesn't exist
INSERT INTO master.worker_type (worker_type_name, worker_type_rate, worker_type_handle, worker_type_desc)
SELECT 'Mason', 600.00, 'mason', 'Skilled worker for masonry work'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.worker_type WHERE worker_type_handle = 'mason'
);

INSERT INTO master.worker_type (worker_type_name, worker_type_rate, worker_type_handle, worker_type_desc)
SELECT 'Half Mason', 500.00, 'half_mason', 'Semi-skilled worker for masonry work'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.worker_type WHERE worker_type_handle = 'half_mason'
);

INSERT INTO master.worker_type (worker_type_name, worker_type_rate, worker_type_handle, worker_type_desc)
SELECT 'Helper', 350.00, 'helper', 'Unskilled worker for general assistance'
    WHERE NOT EXISTS (
    SELECT 1 FROM master.worker_type WHERE worker_type_handle = 'helper'
);
