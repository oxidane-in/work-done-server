package in.oxidane.work.done.common.constant;

public class DbConstants {

    // Database schema name
    public static final String MDM_SCHEMA = "mdm_schema";
    public static final String CORE_SCHEMA = "core_schema";

    // Database table names - mdm_schema
    public static final String PROJECT_STATUS = "project_status";
    public static final String PROJECT_SCOPE = "project_scope";
    public static final String WORKER_TYPE = "worker_type";
    public static final String WORKER = "worker";
    public static final String CLIENT = "client";
    public static final String UNIT_OF_MEASUREMENT = "unit_of_measurement";
    public static final String UNIT_TYPE = "unit_type";
    public static final String MATERIAL_TYPE = "material_type";
    public static final String MATERIAL_VENDOR = "material_vendor";
    public static final String MATERIAL_MANUFACTURER = "material_manufacturer";
    public static final String MATERIAL = "material";
    public static final String LINE_ITEM_CATEGORY = "line_item_category";
    public static final String LINE_ITEM_SUB_CATEGORY = "line_item_sub_category";
    public static final String LINE_ITEM_HEADER = "line_item_header";

    // Database table names - core_schema
    public static final String PROJECT = "project";
    public static final String LINE_ITEM = "line_item";
    public static final String LINE_ITEM_MATERIAL = "line_item_material";
    public static final String LINE_ITEM_WORKER = "line_item_worker";
    public static final String WORK_ORDER = "work_order";
    public static final String WORK_ORDER_LINE_ITEM = "work_order_line_item";
    public static final String WORK_ORDER_MATERIAL_DETAILS = "work_order_material_details";
    public static final String WORK_ORDER_WORKER_DETAILS = "work_order_worker_details";

    //Column names for auditable
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_ON = "created_on";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATED_ON = "updated_on";

    //Foreign Key constraints for Project
    public static final String FK_PROJECT_CLIENT = "fk_project_client";
    public static final String FK_PROJECT_PROJECT_STATUS = "fk_project_projectstatus";

    //Foreign Key constraints for Material
    public static final String FK_MATERIAL_MATERIAL_TYPE = "fk_material_materialtype";
    public static final String FK_MATERIAL_MATERIAL_VENDOR = "fk_material_materialvendor";
    public static final String FK_MATERIAL_MATERIAL_MANUFACTURER = "fk_material_materialmanufacturer";

    //Foreign Key constraints for WorkOrder
    public static final String FK_WORK_ORDER_PROJECT = "fk_workorder_project";
    public static final String FK_WORK_ORDER_LINE_ITEM = "fk_workorder_lineitem";
    public static final String FK_WORK_ORDER_UOM = "fk_workorder_uom";

    //Foreign and Unique constraints for LineItem
    public static final String FK_LINE_ITEM_HEADER = "fk_lineitem_header";
    public static final String FK_LINE_ITEM_CATEGORY = "fk_lineitem_category";
    public static final String FK_LINE_ITEM_SUB_CATEGORY = "fk_lineitem_subcategory";
    public static final String FK_LINE_ITEM_UOM = "fk_lineitem_uom";
    public static final String FK_LINE_ITEM_MATERIAL_LINE_ITEM = "fk_lineitemmaterial_lineitem";
    public static final String FK_LINE_ITEM_MATERIAL_MATERIAL = "fk_lineitemmaterial_material";
    public static final String FK_LINE_ITEM_WORKER_LINE_ITEM = "fk_lineitemworker_lineitem";
    public static final String FK_LINE_ITEM_WORKER_WORKER_TYPE = "fk_lineitemworker_workertype";
    public static final String UK_LINE_ITEM_NAME = "uk_line_item_name";
    public static final String UK_LINE_ITEM_HANDLE = "uk_line_item_handle";

    //Foreign and Unique Key constraints for Client
    public static final String UK_CLIENT_NAME = "uk_client_name";
    public static final String UK_CLIENT_HANDLE = "uk_client_handle";

    // Column names for worker_type table
    public static final String WORKER_TYPE_ID = "worker_type_id";
    public static final String WORKER_TYPE_NAME = "worker_type_name";
    public static final String WORKER_TYPE_RATE = "worker_type_rate";
    public static final String WORKER_TYPE_HANDLE = "worker_type_handle";
    public static final String WORKER_TYPE_DESC = "worker_type_desc";

    // Column names for worker table
    public static final String WORKER_ID = "worker_id";
    public static final String WORKER_NAME = "worker_name";
    public static final String WORKER_RATE = "worker_rate";
    public static final String WORKER_BANK_ACCOUNT = "worker_bank_account";
    public static final String WORKER_IFSC = "worker_ifsc";
    public static final String WORKER_BIRTH_DATE = "worker_birth_date";
    public static final String WORKER_MOBILE_NUMBER = "worker_mobile_number";
    public static final String WORKER_STATE = "worker_state";
    public static final String WORKER_DOJ = "worker_doj";

    // Column names for client table
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_NAME = "client_name";
    public static final String CLIENT_CONTACT_PERSON = "client_contact_person";
    public static final String CLIENT_CONTACT_NUMBER = "client_contact_number";
    public static final String CLIENT_EMAIL = "client_email";
    public static final String CLIENT_ADDRESS = "client_address";
    public static final String CLIENT_HANDLE = "client_handle";
    public static final String CLIENT_DESC = "client_desc";

    // Column names for project table
    public static final String PROJECT_ID = "project_id";
    public static final String PROJECT_NAME = "project_name";
    public static final String PROJECT_LOCATION = "project_location";
    public static final String PROJECT_CITY = "project_city";
    public static final String PROJECT_STATE = "project_state";
    public static final String PROJECT_START_DATE = "project_start_date";
    public static final String PROJECT_END_DATE_PLANNED = "project_end_date_planned";
    public static final String PROJECT_END_DATE_ACTUAL = "project_end_date_actual";
    public static final String WO_NUMBER = "wo_number";
    public static final String WO_DATE = "wo_date";
    public static final String WO_COMPLETION_DATE = "wo_completion_date";
    public static final String TENURE_OF_PROJECT_MONTHS = "tenure_of_project_months";
    public static final String WO_AMOUNT = "wo_amount";

    // Column names for project_scope table
    public static final String PROJECT_SCOPE_ID = "project_scope_id";
    public static final String PROJECT_SCOPE_NAME = "project_scope_name";
    public static final String PROJECT_SCOPE_HANDLE = "project_scope_handle";
    public static final String PROJECT_SCOPE_DESC = "project_scope_desc";

    // Column names for project_status table
    public static final String PROJECT_STATUS_ID = "project_status_id";
    public static final String PROJECT_STATUS_NAME = "project_status_name";
    public static final String PROJECT_STATUS_HANDLE = "project_status_handle";
    public static final String PROJECT_STATUS_DESC = "project_status_desc";

    // Column names for unit_of_measurement table
    public static final String UOM_ID = "uom_id";
    public static final String UOM_NAME = "uom_name";
    public static final String UOM_SYMBOL = "uom_symbol";
    public static final String UOM_HANDLE = "uom_handle";
    public static final String UOM_DESC = "uom_desc";

    // Column names for material table
    public static final String MATERIAL_ID = "material_id";
    public static final String MATERIAL_NAME = "material_name";
    public static final String MATERIAL_UNIT = "material_unit";
    public static final String MATERIAL_PACK_SIZE = "material_pack_size";
    public static final String MATERIAL_RATE_PER_PACK = "material_rate_per_pack";
    public static final String MATERIAL_RATE_PER_UNIT = "material_rate_per_unit";

    // Column names for unit_type table
    public static final String UNIT_TYPE_ID = "unit_type_id";
    public static final String UNIT_TYPE_NAME = "unit_type_name";
    public static final String UNIT_TYPE_HANDLE = "unit_type_handle";
    public static final String UNIT_TYPE_DESC = "unit_type_desc";

    // Column names for material_manufacturer table
    public static final String MATERIAL_MANUFACTURER_ID = "material_manufacturer_id";
    public static final String MATERIAL_MANUFACTURER_NAME = "material_manufacturer_name";
    public static final String MATERIAL_MANUFACTURER_DESC = "material_manufacturer_desc";
    public static final String MATERIAL_MANUFACTURER_HANDLE = "material_manufacturer_handle";

    // Column names for material_type table
    public static final String MATERIAL_TYPE_ID = "material_type_id";
    public static final String MATERIAL_TYPE_NAME = "material_type_name";
    public static final String MATERIAL_TYPE_DESC = "material_type_desc";
    public static final String MATERIAL_TYPE_HANDLE = "material_type_handle";

    // Column names for material_vendor table
    public static final String MATERIAL_VENDOR_ID = "material_vendor_id";
    public static final String MATERIAL_VENDOR_NAME = "material_vendor_name";
    public static final String MATERIAL_VENDOR_DESC = "material_vendor_desc";
    public static final String MATERIAL_VENDOR_HANDLE = "material_vendor_handle";

    // Column names for LineItem table
    public static final String LINE_ITEM_ID = "line_item_id";
    public static final String LINE_ITEM_NAME = "line_item_name";
    public static final String LINE_ITEM_DESC = "line_item_desc";
    public static final String LINE_ITEM_HANDLE = "line_item_handle";

    // Column names for WorkOrder table
    public static final String WORK_ORDER_ID = "work_order_id";
    public static final String QUANTITY = "quantity";
    public static final String RATE = "rate";
    public static final String TOTAL_AMOUNT = "total_amount";

    // Column names for LineItem_Material table
    public static final String LINE_ITEM_MATERIAL_ID = "LineItemMaterialId";
    public static final String CONSUMPTION_PER_UOM = "consumption_per_uom";

    // Column names for LineItem_Worker table
    public static final String LINE_ITEM_WORKER_ID = "line_item_worker_id";
    public static final String WORKER_TYPE_HAJRI = "worker_type_hajri";

    // Column names for LineItem_Category table
    public static final String LINE_ITEM_CATEGORY_ID = "line_item_category_id";
    public static final String LINE_ITEM_CATEGORY_NAME = "line_item_category_name";
    public static final String LINE_ITEM_CATEGORY_HANDLE = "line_item_category_handle";
    public static final String LINE_ITEM_CATEGORY_DESC = "line_item_category_desc";

    // Column names for LineItem_Category table
    public static final String LINE_ITEM_SUB_CATEGORY_ID = "line_item_sub_category_id";
    public static final String LINE_ITEM_SUB_CATEGORY_NAME = "line_item_sub_category_name";
    public static final String LINE_ITEM_SUB_CATEGORY_HANDLE = "line_item_sub_category_handle";
    public static final String LINE_ITEM_SUB_CATEGORY_DESC = "line_item_sub_category_desc";

    // Column names for LineItem_Header table
    public static final String LINE_ITEM_HEADER_ID = "line_item_header_id";
    public static final String LINE_ITEM_HEADER_NAME = "line_item_header_name";
    public static final String LINE_ITEM_HEADER_HANDLE = "line_item_header_handle";
    public static final String LINE_ITEM_HEADER_DESC = "line_item_header_desc";
}
