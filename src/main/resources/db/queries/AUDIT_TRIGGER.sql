-- Function to create audit triggers for all tables with 'updated_on' column across multiple schemas
CREATE OR REPLACE FUNCTION create_audit_triggers_all_schemas()
    RETURNS void AS
$$
DECLARE
    tbl record;
BEGIN
    FOR tbl IN
        SELECT table_schema, table_name
        FROM information_schema.columns
        WHERE column_name = 'updated_on'
          -- Optionally exclude system schemas
          AND table_schema NOT IN ('pg_catalog', 'information_schema')
        LOOP
            -- Check if trigger already exists
            IF NOT EXISTS (SELECT 1
                           FROM information_schema.triggers
                           WHERE event_object_schema = tbl.table_schema
                             AND event_object_table = tbl.table_name
                             AND trigger_name = 'update_' || tbl.table_name ||
                                                '_timestamp') THEN
                EXECUTE format('
                CREATE TRIGGER update_%s_timestamp
                BEFORE UPDATE ON %I.%I
                FOR EACH ROW
                EXECUTE FUNCTION public.update_timestamp();
            ', tbl.table_name, tbl.table_schema, tbl.table_name);

                RAISE NOTICE 'Created trigger for %.%', tbl.table_schema, tbl.table_name;
            END IF;
        END LOOP;
END;
$$ LANGUAGE plpgsql;

-- Run this to create triggers for all tables with updated_on column across all schemas
SELECT create_audit_triggers_all_schemas();
