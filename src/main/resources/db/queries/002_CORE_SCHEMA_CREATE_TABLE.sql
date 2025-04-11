CREATE TABLE core_schema.line_item_template
(
    line_item_template_id     BIGSERIAL PRIMARY KEY,
    line_item_template_name   VARCHAR(500) NOT NULL UNIQUE,
    line_item_template_desc   VARCHAR(500) NOT NULL,
    line_item_template_handle VARCHAR(500) NOT NULL UNIQUE,
    created_by                VARCHAR(50),
    created_on                TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                VARCHAR(50),
    updated_on                TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for frequently searched columns
CREATE INDEX idx_line_item_template_name
    ON core_schema.line_item_template (line_item_template_name);
CREATE INDEX idx_line_item_template_handle
    ON core_schema.line_item_template (line_item_template_handle);

-- Create project table
CREATE TABLE core_schema.project
(
    project_id               BIGSERIAL PRIMARY KEY,
    project_name             VARCHAR(500),
    project_location         VARCHAR(500),
    client_id                BIGINT NOT NULL REFERENCES mdm_schema.client (client_id),
    project_status_id        BIGINT NOT NULL REFERENCES mdm_schema.project_status (project_status_id),
    project_start_date       DATE   NOT NULL,
    project_end_date_planned DATE   NOT NULL,
    project_end_date_actual  DATE,
    tenure_of_project_months BIGINT GENERATED ALWAYS AS (
        EXTRACT(YEAR FROM
                AGE(COALESCE(project_end_date_actual, project_end_date_planned),
                    project_start_date)) * 12 +
        EXTRACT(MONTH FROM
                AGE(COALESCE(project_end_date_actual, project_end_date_planned),
                    project_start_date))
        ) STORED,
    created_by               VARCHAR(50),
    created_on               TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by               VARCHAR(50),
    updated_on               TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_project_client ON core_schema.project (client_id);
CREATE INDEX idx_project_status ON core_schema.project (project_status_id);
CREATE INDEX idx_project_dates ON core_schema.project (project_start_date, project_end_date_planned);


CREATE TABLE core_schema.work_order
(
    work_order_id                        BIGSERIAL PRIMARY KEY,
    work_order_number                    VARCHAR(50)    NOT NULL UNIQUE,
    work_order_desc                      VARCHAR(500)   NOT NULL,
    work_order_date                      DATE,
    project_id                           BIGINT         NOT NULL REFERENCES core_schema.project (project_id),
    work_order_line_item_id              BIGINT         NOT NULL REFERENCES mdm_schema.line_item (line_item_id),
    work_order_line_item_scope_id        BIGINT         NOT NULL REFERENCES mdm_schema.project_scope (project_scope_id),
    work_order_line_item_qty             DECIMAL(10, 2) NOT NULL,
    work_order_line_item_rate            DECIMAL(10, 2) NOT NULL,
    work_order_line_item_worker_constant DECIMAL(10, 2) NOT NULL,
    created_by                           VARCHAR(50),
    created_on                           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                           VARCHAR(50),
    updated_on                           TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_work_order_project ON core_schema.work_order (project_id);
CREATE INDEX idx_work_order_line_item ON core_schema.work_order (work_order_line_item_id);
CREATE INDEX idx_work_order_scope ON core_schema.work_order (work_order_line_item_scope_id);


CREATE TABLE core_schema.line_item_worker_template
(
    line_item_worker_template_id        BIGSERIAL PRIMARY KEY,
    line_item_template_id               BIGINT         NOT NULL REFERENCES core_schema.line_item_template (line_item_template_id),
    template_line_item_id               BIGINT         NOT NULL REFERENCES mdm_schema.line_item (line_item_id),
    template_worker_type_id             BIGINT         NOT NULL REFERENCES mdm_schema.worker_type (worker_type_id),
    template_worker_type_hours_required DECIMAL(10, 2) NOT NULL,
    created_by                          VARCHAR(50),
    created_on                          TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                          VARCHAR(50),
    updated_on                          TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_worker_template_template ON core_schema.line_item_worker_template (line_item_template_id);
CREATE INDEX idx_worker_template_line_item ON core_schema.line_item_worker_template (template_line_item_id);
CREATE INDEX idx_worker_template_worker_type ON core_schema.line_item_worker_template (template_worker_type_id);


CREATE TABLE core_schema.line_item_material_template
(
    line_item_material_template_id        BIGSERIAL PRIMARY KEY,
    line_item_template_id                 BIGINT         NOT NULL REFERENCES core_schema.line_item_template (line_item_template_id),
    template_line_item_id                 BIGINT         NOT NULL REFERENCES mdm_schema.line_item (line_item_id),
    template_material_id                  BIGINT         NOT NULL REFERENCES mdm_schema.material (material_id),
    template_material_consumption_per_uom DECIMAL(10, 2) NOT NULL,
    created_by                            VARCHAR(50),
    created_on                            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                            VARCHAR(50),
    updated_on                            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_line_item_material UNIQUE (line_item_template_id, template_material_id)
);

CREATE INDEX idx_material_template_template ON core_schema.line_item_material_template (line_item_template_id);
CREATE INDEX idx_material_template_line_item ON core_schema.line_item_material_template (template_line_item_id);
CREATE INDEX idx_material_template_material ON core_schema.line_item_material_template (template_material_id);


CREATE TABLE core_schema.work_order_detail
(
    work_order_detail_id             BIGSERIAL PRIMARY KEY,
    work_order_id                    BIGINT         NOT NULL REFERENCES core_schema.work_order (work_order_id),
    work_order_number                VARCHAR(50)    NOT NULL,
    wod_line_item_id                 BIGINT         NOT NULL REFERENCES mdm_schema.line_item (line_item_id),
    wod_material_id                  BIGINT         NOT NULL REFERENCES mdm_schema.material (material_id),
    wod_material_consumption_per_uom DECIMAL(18, 2) NOT NULL,
    wod_worker_type_id               BIGINT         NOT NULL REFERENCES mdm_schema.worker_type (worker_type_id),
    wod_worker_type_hours_required   DECIMAL(10, 2) NOT NULL,
    created_by                       VARCHAR(50),
    created_on                       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by                       VARCHAR(50),
    updated_on                       TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_work_order_detail_wo ON core_schema.work_order_detail (work_order_id);
CREATE INDEX idx_work_order_detail_line_item ON core_schema.work_order_detail (wod_line_item_id);
CREATE INDEX idx_work_order_detail_material ON core_schema.work_order_detail (wod_material_id);
CREATE INDEX idx_work_order_detail_worker ON core_schema.work_order_detail (wod_worker_type_id);


CREATE TABLE core_schema.project_other_cost
(
    other_cost_id     BIGSERIAL PRIMARY KEY,
    work_order_id     BIGINT         NOT NULL REFERENCES core_schema.work_order (work_order_id),
    other_cost_desc   VARCHAR(500)   NOT NULL,
    other_cost_amount DECIMAL(18, 2) NOT NULL,
    other_cost_date   DATE           NOT NULL  DEFAULT CURRENT_DATE,
    created_by        VARCHAR(50),
    created_on        TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by        VARCHAR(50),
    updated_on        TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_project_other_cost_work_order
    ON core_schema.project_other_cost (work_order_id);
CREATE INDEX idx_project_other_cost_date
    ON core_schema.project_other_cost (other_cost_date);
