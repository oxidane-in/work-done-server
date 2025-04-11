INSERT INTO core_schema.worker
(worker_code, worker_name, worker_type_id, rate, bank_account, ifsc, birth_date, mobile_number, state, joining_date)
SELECT v.worker_code, v.worker_name, v.worker_type_id, v.rate, v.bank_account, v.ifsc, v.birth_date, v.mobile_number, v.state, v.joining_date
FROM (
      VALUES
          ('WK0001', 'Amit Sharma', 1, 500.00, '123456789012', 'HDFC0001234', '1990-05-12', '9876543210', 'Maharashtra', '2023-01-15'),
          ('WK0002',' Ravi Kumar', 2, 450.00, '123456789013', 'ICIC0005678', '1988-08-25', '9876543211', 'Karnataka', '2023-02-10'),
          ('WK0003', 'Suraj Gupta', 3, 400.00, '123456789014', 'SBI0007890', '1992-12-30', '9876543212', 'Uttar Pradesh', '2023-03-05'),
          ('WK0004', 'Mahesh Patil', 1, 520.00, '123456789015', 'AXIS0001111', '1995-07-14', '9876543213', 'Maharashtra', '2023-04-20'),
          ('WK0005', 'Suresh Yadav', 2, 460.00, '123456789016', 'BOB0002222', '1985-09-18', '9876543214', 'Gujarat', '2023-05-25'),
          ('WK0006', 'Ramesh Singh', 3, 410.00, '123456789017', 'PNB0003333', '1993-06-22', '9876543215', 'Rajasthan', '2023-06-30'),
          ('WK0007', 'Vikram Chauhan', 1, 530.00, '123456789018', 'CANB0004444', '1991-11-05', '9876543216', 'Madhya Pradesh', '2023-07-10'),
          ('WK0008', 'Nilesh Mehta', 2, 470.00, '123456789019', 'IND0005555', '1989-04-28', '9876543217', 'West Bengal', '2023-08-15'),
          ('WK0009', 'Deepak Verma', 3, 420.00, '123456789020', 'YESB0006666', '1994-03-12', '9876543218', 'Bihar', '2023-09-05'),
          ('WK0010', 'Karan Joshi', 1, 540.00, '123456789021', 'HSBC0007777', '1996-02-17', '9876543219', 'Punjab', '2023-10-10'),
          ('WK0011', 'Rohit Mishra', 2, 480.00, '123456789022', 'CITI0008888', '1990-08-09', '9876543220', 'Haryana', '2023-11-20'),
          ('WK0012', 'Prakash Naik', 3, 430.00, '123456789023', 'UBI0009999', '1993-01-05', '9876543221', 'Goa', '2023-12-01'),
          ('WK0013', 'Ajay Desai', 1, 550.00, '123456789024', 'DBS0001010', '1987-06-30', '9876543222', 'Karnataka', '2024-01-15'),
          ('WK0014', 'Sanjay Rawat', 2, 490.00, '123456789025', 'SCBL0002020', '1992-05-21', '9876543223', 'Himachal Pradesh', '2024-02-10'),
          ('WK0015', 'Dinesh Pawar', 3, 440.00, '123456789026', 'UCOB0003030', '1995-10-11', '9876543224', 'Chhattisgarh', '2024-03-05')

    ) AS v(worker_code, worker_name, worker_type_id, rate, bank_account, ifsc, birth_date, mobile_number, state, joining_date)
WHERE NOT EXISTS (
    SELECT 1 FROM core_schema.worker WHERE worker_code = v.worker_code
);
