-- TODO: Add audit fields - created_by, created_on, updated_by, updated_on

CREATE TABLE mdm_schema.unit_of_measurement
(
    uom_id          BIGSERIAL PRIMARY KEY,
    uom_name        VARCHAR(50) UNIQUE NOT NULL,
    uom_symbol      VARCHAR(20) UNIQUE,
    uom_handle      VARCHAR(50) UNIQUE NOT NULL,
    uom_handle_desc VARCHAR(255)
);

CREATE TABLE mdm_schema.worker_type
(
    worker_type_id     BIGSERIAL PRIMARY KEY,
    worker_type_name   VARCHAR(50) UNIQUE NOT NULL,
    worker_type_rate   DECIMAL(10, 2)     NOT NULL,
    worker_type_handle VARCHAR(50) UNIQUE NOT NULL,
    worker_type_desc   VARCHAR(255),
    created_by         VARCHAR(50),
    created_on         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by         VARCHAR(50),
    updated_on         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.project_scope
(
    project_scope_id     BIGSERIAL PRIMARY KEY,
    project_scope_name   VARCHAR(100) UNIQUE NOT NULL,
    project_scope_handle VARCHAR(100) UNIQUE NOT NULL,
    project_scope_desc   VARCHAR(255),
    created_by           VARCHAR(50),
    created_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by           VARCHAR(50),
    updated_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.project_status
(
    project_status_id     BIGSERIAL PRIMARY KEY,
    project_status_name   VARCHAR(50) UNIQUE NOT NULL,
    project_status_handle VARCHAR(50) UNIQUE NOT NULL,
    project_status_desc   VARCHAR(255),
    created_by            VARCHAR(50),
    created_on            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by            VARCHAR(50),
    updated_on            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.material_manufacturer
(
    material_manufacturer_id     BIGSERIAL PRIMARY KEY,
    material_manufacturer_name   VARCHAR(255) UNIQUE NOT NULL,
    material_manufacturer_desc   VARCHAR(255),
    material_manufacturer_handle VARCHAR(255) UNIQUE NOT NULL,
    created_by                   VARCHAR(50),
    created_on                   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                   VARCHAR(50),
    updated_on                   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.material_type
(
    material_type_id     BIGSERIAL PRIMARY KEY,
    material_type_name   VARCHAR(255) UNIQUE NOT NULL,
    material_type_desc   VARCHAR(255),
    material_type_handle VARCHAR(255) UNIQUE NOT NULL,
    created_by           VARCHAR(50),
    created_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by           VARCHAR(50),
    updated_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.material_vendor
(
    material_vendor_id     BIGSERIAL PRIMARY KEY,
    material_vendor_name   VARCHAR(255) UNIQUE NOT NULL,
    material_vendor_desc   VARCHAR(255),
    material_vendor_handle VARCHAR(255) UNIQUE NOT NULL,
    created_by             VARCHAR(50),
    created_on             TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by             VARCHAR(50),
    updated_on             TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.client
(
    client_id             BIGSERIAL PRIMARY KEY,
    client_name           VARCHAR(100) UNIQUE NOT NULL,
    client_contact_person VARCHAR(100),
    client_contact_number VARCHAR(15),
    client_email          VARCHAR(100),
    client_address        TEXT,
    client_handle         VARCHAR(100) UNIQUE  NOT NULL,
    client_desc           VARCHAR(255),
    created_by            VARCHAR(50),
    created_on            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by            VARCHAR(50),
    updated_on            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.material
(
    material_id              BIGSERIAL PRIMARY KEY,
    material_name            VARCHAR(255) UNIQUE NOT NULL,
    material_manufacturer_id BIGINT REFERENCES mdm_schema.material_manufacturer (material_manufacturer_id),
    material_vendor_id       BIGINT REFERENCES mdm_schema.material_vendor (material_vendor_id),
    material_type_id         BIGINT REFERENCES mdm_schema.material_type (material_type_id),
    material_uom_id          BIGINT REFERENCES mdm_schema.unit_of_measurement (uom_id),
    material_pack_size       DECIMAL(10, 2)      NOT NULL,
    material_rate_per_pack   DECIMAL(10, 2),
    material_rate_per_unit   DECIMAL(10, 2) GENERATED ALWAYS AS (material_rate_per_pack /
                                                                 NULLIF(material_pack_size, 0)) STORED,
    created_by               VARCHAR(50),
    created_on               TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by               VARCHAR(50),
    updated_on               TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.line_item
(
    line_item_id        BIGSERIAL PRIMARY KEY,
    line_item_name      VARCHAR(255) UNIQUE                                       NOT NULL,
    line_item_desc      VARCHAR(500),
    line_item_category1 VARCHAR(500),
    line_item_category2 VARCHAR(500),
    line_item_handle    VARCHAR(100) UNIQUE                                       NOT NULL,
    uom_id              BIGINT REFERENCES mdm_schema.unit_of_measurement (uom_id) NOT NULL,
    created_by          VARCHAR(50),
    created_on          TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by          VARCHAR(50),
    updated_on          TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mdm_schema.worker
(
    worker_id            BIGSERIAL PRIMARY KEY,
    worker_name          VARCHAR(255)                                              NOT NULL,
    worker_type_id       BIGINT REFERENCES mdm_schema.worker_type (worker_type_id) NOT NULL,
    worker_rate          DECIMAL(10, 2)                                            NOT NULL,
    worker_bank_account  VARCHAR(20)                                               NOT NULL,
    worker_ifsc          VARCHAR(11)                                               NOT NULL,
    worker_birth_date    DATE                                                      NOT NULL,
    worker_mobile_number VARCHAR(15)                                               NOT NULL,
    worker_state         VARCHAR(100)                                              NOT NULL,
    worker_doj           DATE                                                      NOT NULL,
    created_by           VARCHAR(50),
    created_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by           VARCHAR(50),
    updated_on           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
