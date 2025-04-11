-- Insert records into customer if they don't exist
INSERT INTO core_schema.customer
    (customer_name, customer_contact_person, customer_contact_number, customer_email, customer_adddress, customer_handle, customer_desc)
SELECT v.customer_name, v.customer_contact_person, v.customer_contact_number, v.customer_email, v.customer_adddress, v.customer_handle, v.customer_desc
FROM (
        VALUES
            ('ABC Constructions', 'John Doe', '9876543210', 'john.doe@abc.com', '123 Street, City', 'abc_constructions', 'Leading construction company specializing in residential projects'),
            ('XYZ Developers', 'Jane Smith', '9876543220', 'jane.smith@xyz.com', '456 Avenue, City', 'xyz_developers', 'Real estate development company focusing on commercial projects'),
            ('PQR Builders', 'Michael Lee', '9876543230', 'michael.lee@pqr.com', '789 Road, City', 'pqr_builders', 'Renowned builder in commercial projects'),
            ('LMN Contractors', 'Sarah Brown', '9876543240', 'sarah.brown@lmn.com', '1011 Highway, City', 'lmn_contractors', 'Expert contractors in waterproofing solutions'),
            ('OPQ Developers', 'Robert White', '9876543250', 'robert.white@opq.com', '2022 Avenue, City', 'opq_developers', 'Premium developers for high-rise apartments')
    ) AS v(customer_name, customer_contact_person, customer_contact_number, customer_email, customer_adddress, customer_handle, customer_desc)
WHERE NOT EXISTS (
    SELECT 1 FROM core_schema.customer c WHERE c.customer_handle = v.customer_handle
);
