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
    public static final String LI_MATERIAL = "li_material";
    public static final String LI_WORKER = "li_worker";
    public static final String WORK_ORDER = "work_order";
    public static final String WO_LINE_ITEMS = "wo_line_items";
    public static final String WO_MATERIAL_DETAILS = "wo_material_details";
    public static final String WO_WORKER_DETAILS = "wo_worker_details";

    //Column names for auditable
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_ON = "created_on";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATED_ON = "updated_on";

    //Foreign and Unique Key constraints for Project
    public static final String FK_PROJECT_CLIENT_ID = "fk_project_client_id";
    public static final String FK_PROJECT_PROJECT_STATUS_ID = "fk_project_projectstatus_id";
    public static final String UK_PROJECT_NAME = "uk_project_name";
    public static final String UK_PROJECT_CODE = "uk_project_code";
    public static final String UK_PROJECT_STATUS_NAME = "uk_project_status_name";
    public static final String UK_PROJECT_STATUS_HANDLE = "uk_project_status_handle";
    public static final String UK_PROJECT_SCOPE_NAME = "uk_project_scope_name";
    public static final String UK_PROJECT_SCOPE_HANDLE = "uk_project_scope_handle";

    //Foreign and Unique Key constraints for Material
    public static final String FK_MATERIAL_MATERIAL_TYPE_ID = "fk_material_materialtype_id";
    public static final String FK_MATERIAL_MATERIAL_VENDOR_ID = "fk_material_materialvendor_id";
    public static final String FK_MATERIAL_MATERIAL_MANUFACTURER_ID = "fk_material_materialmanufacturer_id";
    public static final String FK_MATERIAL_UOM_ID = "fk_material_uom_id";
    public static final String UK_MATERIAL_NAME = "uk_material_name";
    public static final String UK_MATERIAL_VENDOR_NAME = "uk_material_vendor_name";
    public static final String UK_MATERIAL_VENDOR_HANDLE = "uk_material_vendor_handle";
    public static final String UK_MATERIAL_MANUFACTURER_NAME = "uk_material_manufacturer_name";
    public static final String UK_MATERIAL_MANUFACTURER_HANDLE = "uk_material_manufacturer_handle";
    public static final String UK_MATERIAL_TYPE_NAME = "uk_material_type_name";
    public static final String UK_MATERIAL_TYPE_HANDLE = "uk_material_type_handle";

    //Foreign and Unique Key constraints for WorkOrder
    public static final String FK_WO_PROJECT_ID = "fk_wo_project_id";
    public static final String FK_WORK_ORDER_ID = "fk_workorder_id";
    public static final String FK_WO_LINE_ITEM_ID = "fk_wo_lineitem_id";
    public static final String FK_WO_WORKER_TYPE_ID = "fk_wo_workertype_id";
    public static final String FK_WOLI_LINE_ITEM_ID = "fk_woli_lineitem_id";
    public static final String FK_WO_MATERIAL_ID = "fk_wo_material_id";
    public static final String UK_WORK_ORDER_CODE = "uk_workorder_code";

    //Foreign and Unique constraints for LineItem
    public static final String FK_LINE_ITEM_HEADER = "fk_lineitem_header";
    public static final String FK_LINE_ITEM_CATEGORY = "fk_lineitem_category";
    public static final String FK_LINE_ITEM_SUB_CATEGORY = "fk_lineitem_subcategory";
    public static final String FK_LINE_ITEM_UOM = "fk_lineitem_uom";
    public static final String FK_LINE_ITEM_MATERIAL_LINE_ITEM = "fk_lineitemmaterial_lineitem";
    public static final String FK_LINE_ITEM_MATERIAL_MATERIAL = "fk_lineitemmaterial_material";
    public static final String FK_LINE_ITEM_WORKER_LINE_ITEM = "fk_lineitemworker_lineitem";
    public static final String FK_LINE_ITEM_WORKER_WORKER_TYPE = "fk_lineitemworker_workertype";
    public static final String FK_LINE_ITEM_CATEGORY_ID = "fk_lineitem_category_id";
    public static final String UK_LINE_ITEM_NAME = "uk_line_item_name";
    public static final String UK_LINE_ITEM_HANDLE = "uk_line_item_handle";
    public static final String UK_LINE_ITEM_CATEGORY_NAME = "uk_line_item_category_name";
    public static final String UK_LINE_ITEM_SUB_CATEGORY_NAME = "uk_line_item_sub_category_name";
    public static final String UK_LINE_ITEM_HEADER_NAME = "uk_line_item_header_name";
    public static final String UK_LINE_ITEM_CATEGORY_HANDLE = "uk_line_item_category_handle";
    public static final String UK_LINE_ITEM_SUB_CATEGORY_HANDLE = "uk_line_item_sub_category_handle";
    public static final String UK_LINE_ITEM_HEADER_HANDLE = "uk_line_item_header_handle";

    //Foreign and Unique Key constraints for Client
    public static final String UK_CLIENT_NAME = "uk_client_name";
    public static final String UK_CLIENT_HANDLE = "uk_client_handle";

    //Foreign and Unique Key constraints for Worker
    public static final String FK_WORKER_TYPE = "fk_worker_workertype";
    public static final String UK_WORKER_NAME = "uk_worker_name";
    public static final String UK_WORKER_MOBILE_NUMBER = "uk_worker_mobile_number";
    public static final String UK_WORKER_TYPE_NAME = "uk_worker_type_name";
    public static final String UK_WORKER_TYPE_HANDLE = "uk_worker_type_handle";

    //Unique Key constraints for UOM
    public static final String UK_UOM_NAME = "uk_uom_name";
    public static final String UK_UOM_SYMBOL = "uk_uom_symbol";
    public static final String UK_UOM_HANDLE = "uk_uom_handle";

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
    public static final String PROJECT_CODE = "project_code";
    public static final String PROJECT_NAME = "project_name";
    public static final String PROJECT_LOCATION = "project_location";
    public static final String PROJECT_CITY = "project_city";
    public static final String PROJECT_STATE = "project_state";
    public static final String PROJECT_START_DATE = "project_start_date";
    public static final String PROJECT_END_DATE_PLANNED = "project_end_date_planned";
    public static final String PROJECT_END_DATE_ACTUAL = "project_end_date_actual";
    public static final String TENURE_OF_PROJECT_MONTHS = "tenure_of_project_months";

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

    // Column names for line_item table
    public static final String LINE_ITEM_ID = "line_item_id";
    public static final String LINE_ITEM_NAME = "line_item_name";
    public static final String LINE_ITEM_DESC = "line_item_desc";
    public static final String LINE_ITEM_HANDLE = "line_item_handle";

    // Column names for work_order table
    public static final String WORK_ORDER_ID = "work_order_id";
    public static final String WORK_ORDER_CODE = "work_order_code";
    public static final String WORK_ORDER_DATE = "work_order_date";
    public static final String WORK_ORDER_DESC = "work_order_desc";

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

    // Column names for WorkOrder_LineItems table
    public static final String WORK_ORDER_LINE_ITEM_ID = "work_order_line_item_id";
    public static final String WO_ALLOCATED_LINE_ITEM_ID = "wo_allocated_line_item_id";
    public static final String WO_LINE_ITEM_QTY = "wo_line_item_qty";
    public static final String WO_LINE_ITEM_RATE = "wo_line_item_rate";
    public static final String WO_LINE_ITEM_WORKER_CONSTANT = "wo_line_item_worker_constant";

    // Column names for WorkOrder_MaterialDetails table
    public static final String WO_MATERIAL_DETAIL_ID = "wo_material_detail_id";
    public static final String WO_MATERIAL_ID = "wo_material_id";
    public static final String WO_MATERIAL_CONSUMPTION_PER_UOM = "wo_material_consumption_per_uom";
    public static final String WO_LINE_ITEM_ID = "wo_lineitem_id";

    // Column names for WorkOrder_WorkerDetails table
    public static final String WO_WORKER_DETAIL_ID = "wo_worker_detail_id";
    public static final String WO_WORKER_TYPE_ID = "wo_worker_type_id";
    public static final String WO_WORKER_TYPE_REQUIRED_PER_UOM = "wo_worker_type_required_per_uom";
    public static final String WO_WORKER_TYPE_RATE_PER_HAJRI = "wo_worker_type_rate_per_hajri";
}
