BEGIN;

INSERT INTO master.worker_type (worker_type_name, worker_type_rate, worker_type_handle, worker_type_desc)
SELECT v.worker_type_name, v.worker_type_rate, v.worker_type_handle, v.worker_type_desc
FROM (
    VALUES
        ('Mason', 600.00, 'mason', 'Skilled worker for masonry work'),
        ('Half Mason', 500.00, 'half_mason', 'Semi-skilled worker for masonry work'),
        ('Helper', 350.00, 'helper', 'Unskilled worker for general assistance')
) AS v(worker_type_name, worker_type_rate, worker_type_handle, worker_type_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM master.worker_type WHERE worker_type_handle = v.worker_type_handle
);

COMMIT;
