-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS core_schema;

-- Line Item Table
CREATE TABLE core_schema.line_item (
    line_item_id BIGSERIAL NOT NULL,
    line_item_name VARCHAR NOT NULL,
    line_item_desc VARCHAR NULL,
    line_item_handle VARCHAR NOT NULL,
    uom_id BIGINT NOT NULL,
    CONSTRAINT fk_line_item_uom FOREIGN KEY (uom_id)
        REFERENCES master_schema.unit_of_measurement(uom_id)
);
