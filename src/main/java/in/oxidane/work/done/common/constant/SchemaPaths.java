package in.oxidane.work.done.common.constant;

public final class SchemaPaths {

    private SchemaPaths() {
        // prevent instantiation
    }

    // LineItem Schema
    public static final String CREATE_LINE_ITEM_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-request.json";
    public static final String UPDATE_LINE_ITEM_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-request.json";
    public static final String CREATE_LINE_ITEM_HEADER_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-header-request.json";
    public static final String UPDATE_LINE_ITEM_HEADER_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-header-request.json";
    public static final String CREATE_LINE_ITEM_MATERIAL_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-material-request.json";
    public static final String UPDATE_LINE_ITEM_MATERIAL_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-material-request.json";
    public static final String CREATE_LINE_ITEM_WORKER_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-worker-request.json";
    public static final String UPDATE_LINE_ITEM_WORKER_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-worker-request.json";
    public static final String CREATE_LINE_ITEM_CATEGORY_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-category-request.json";
    public static final String UPDATE_LINE_ITEM_CATEGORY_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-category-request.json";
    public static final String CREATE_LINE_ITEM_SUB_CATEGORY_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/create-line-item-sub-category-request.json";
    public static final String UPDATE_LINE_ITEM_SUB_CATEGORY_REQUEST_SCHEMA = "classpath:schema.v1/lineitem/update-line-item-sub-category-request.json";

    // Material Schema
    public static final String CREATE_MATERIAL_REQUEST_SCHEMA = "classpath:schema.v1/material/create-material-request.json";
    public static final String UPDATE_MATERIAL_REQUEST_SCHEMA = "classpath:schema.v1/material/update-material-request.json";
    public static final String CREATE_MATERIAL_TYPE_REQUEST_SCHEMA = "classpath:schema.v1/material/create-material-type-request.json";
    public static final String UPDATE_MATERIAL_TYPE_REQUEST_SCHEMA = "classpath:schema.v1/material/update-material-type-request.json";
    public static final String CREATE_MATERIAL_VENDOR_REQUEST_SCHEMA = "classpath:schema.v1/material/create-material-vendor-request.json";
    public static final String UPDATE_MATERIAL_VENDOR_REQUEST_SCHEMA = "classpath:schema.v1/material/update-material-vendor-request.json";
    public static final String CREATE_MATERIAL_MANUFACTURER_REQUEST_SCHEMA = "classpath:schema.v1/material/create-material-manufacturer-request.json";
    public static final String UPDATE_MATERIAL_MANUFACTURER_REQUEST_SCHEMA = "classpath:schema.v1/material/update-material-manufacturer-request.json";

    // Order Schema
    public static final String CREATE_UNIT_OF_MEASUREMENT_REQUEST_SCHEMA = "classpath:schema.v1/order/create-unit-of-measurement-request.json";
    public static final String UPDATE_UNIT_OF_MEASUREMENT_REQUEST_SCHEMA = "classpath:schema.v1/order/update-unit-of-measurement-request.json";

    //Project Schema
    public static final String CREATE_CLIENT_REQUEST_SCHEMA = "classpath:schema.v1/project/create-client-request.json";
    public static final String UPDATE_CLIENT_REQUEST_SCHEMA = "classpath:schema.v1/project/update-client-request.json";
    public static final String CREATE_PROJECT_REQUEST_SCHEMA = "classpath:schema.v1/project/create-project-request.json";
    public static final String UPDATE_PROJECT_REQUEST_SCHEMA = "classpath:schema.v1/project/update-project-request.json";
    public static final String CREATE_PROJECT_SCOPE_REQUEST_SCHEMA = "classpath:schema.v1/project/create-project-scope-request.json";
    public static final String UPDATE_PROJECT_SCOPE_REQUEST_SCHEMA = "classpath:schema.v1/project/update-project-scope-request.json";
    public static final String CREATE_PROJECT_STATUS_REQUEST_SCHEMA = "classpath:schema.v1/project/create-project-status-request.json";
    public static final String UPDATE_PROJECT_STATUS_REQUEST_SCHEMA = "classpath:schema.v1/project/update-project-status-request.json";
    public static final String CREATE_PROJECT_OTHER_COST_ACTUAL_SCHEMA = "classpath:schema.v1/project/create-project-other-cost-actual.json";
    public static final String UPDATE_PROJECT_OTHER_COST_ACTUAL_SCHEMA = "classpath:schema.v1/project/update-project-other-cost-actual.json";
    public static final String CREATE_PROJECT_OTHER_COST_PLANNED_SCHEMA = "classpath:schema.v1/project/create-project-other-cost-planned.json";
    public static final String UPDATE_PROJECT_OTHER_COST_PLANNED_SCHEMA = "classpath:schema.v1/project/update-project-other-cost-planned.json";


    // Worker Schema
    public static final String CREATE_WORKER_REQUEST_SCHEMA = "classpath:schema.v1/worker/create-worker-request.json";
    public static final String UPDATE_WORKER_REQUEST_SCHEMA = "classpath:schema.v1/worker/update-worker-request.json";
    public static final String CREATE_WORKER_TYPE_REQUEST_SCHEMA = "classpath:schema.v1/worker/create-worker-type-request.json";
    public static final String UPDATE_WORKER_TYPE_REQUEST_SCHEMA = "classpath:schema.v1/worker/update-worker-type-request.json";

    // Work Order Schema
    public static final String CREATE_WORK_ORDER_REQUEST_SCHEMA = "classpath:schema.v1/order/create-work-order-request-schema.json";
    public static final String UPDATE_WORK_ORDER_REQUEST_SCHEMA = "classpath:schema.v1/order/update-work-order-request-schema.json";
    public static final String CREATE_WORK_ORDER_LINE_ITEMS_REQUEST_SCHEMA = "classpath:schema.v1/order/create-work-order-line-items-request-schema.json";
    public static final String UPDATE_WORK_ORDER_LINE_ITEMS_REQUEST_SCHEMA = "classpath:schema.v1/order/update-work-order-line-items-request-schema.json";
    public static final String CREATE_WORK_ORDER_OTHER_COST_ACTUAL_SCHEMA = "classpath:schema.v1/order/create-work-order-other-cost-actual.json";
    public static final String UPDATE_WORK_ORDER_OTHER_COST_ACTUAL_SCHEMA = "classpath:schema.v1/order/update-work-order-other-cost-actual.json";
    public static final String UPDATE_WORK_ORDER_OTHER_COST_PLANNED_SCHEMA = "classpath:schema.v1/order/update-work-order-other-cost-planned.json";
    public static final String CREATE_WORK_ORDER_OTHER_COST_PLANNED_SCHEMA = "classpath:schema.v1/order/create-work-order-other-cost-planned.json";
    public static final String CREATE_WORK_ORDER_MATERIAL_DETAILS_REQUEST_SCHEMA = "classpath:schema.v1/order/create-work-order-material-details-request-schema.json";
    public static final String UPDATE_WORK_ORDER_MATERIAL_DETAILS_REQUEST_SCHEMA = "classpath:schema.v1/order/update-work-order-material-details-request-schema.json";
    public static final String CREATE_WORK_ORDER_WORKER_DETAILS_REQUEST_SCHEMA = "classpath:schema.v1/order/create-work-order-worker-details-request-schema.json";
    public static final String UPDATE_WORK_ORDER_WORKER_DETAILS_REQUEST_SCHEMA = "classpath:schema.v1/order/update-work-order-worker-details-request-schema.json";

    // OtherCostItem Schema
    public static final String CREATE_OTHER_COST_ITEM_REQUEST_SCHEMA = "classpath:schema.v1/shared/create-other-cost-item-request.json";
    public static final String UPDATE_OTHER_COST_ITEM_REQUEST_SCHEMA = "classpath:schema.v1/shared/update-other-cost-item-request.json";

}
