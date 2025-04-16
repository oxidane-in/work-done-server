package in.oxidane.work.done.common.constant;

public class Endpoints {

    public static final String BASE_URL = "https://api.oxidane.in";

    public static final String API_V1 = "/v1";

    // health check
    public static final String HEALTH_CHECK = "/health/check";

    // Building
    public static final String UNIT_TYPE_V1 = API_V1 + "/unit-types";

    //LineItem
    public static final String LINE_ITEM_CATEGORY_V1 = API_V1 + "/line-item-categories";
    public static final String LINE_ITEM_HEADER_V1 = API_V1 + "/line-item-headers";
    public static final String LINE_ITEM_MATERIAL_V1 = API_V1 + "/line-item-materials";
    public static final String LINE_ITEM_SUB_CATEGORY_V1 = API_V1 + "/line-item-sub-categories";
    public static final String LINE_ITEM_WORKER_V1 = API_V1 + "/line-item-workers";

    // Material
    public static final String MATERIAL_V1 = API_V1 + "/materials";
    public static final String MATERIAL_MANUFACTURER_V1 = API_V1 + "/material-manufacturers";
    public static final String MATERIAL_VENDOR_V1 = API_V1 + "/material-vendors";
    public static final String MATERIAL_TYPE_V1 = API_V1 + "/material-types";

    // Order
    public static final String WORK_ORDER_V1 = API_V1 + "/work-orders";
    public static final String WORK_ORDER_LINE_ITEMS_V1 = API_V1 + "/work-order-line-items";
    public static final String LINE_ITEM_V1 = API_V1 + "/line-items";
    public static final String UNIT_OF_MEASUREMENT_V1 = API_V1 + "/unit-of-measurements";
    public static final String WORK_ORDER_MATERIAL_DETAILS_V1 = API_V1 + "/work-order-material-details";
    public static final String WORK_ORDER_WORKER_DETAILS_V1 = API_V1 + "/work-order-worker-details";
    public static final String WORK_ORDER_OTHER_COST_ACTUAL_V1 = API_V1 + "/work-order-other-cost-actual";
    public static final String WORK_ORDER_OTHER_COST_PLANNED_V1 =  API_V1 + "/work-order-other-cost-planned";

    // Project
    public static final String PROJECT_V1 = API_V1 + "/projects";
    public static final String PROJECT_SCOPE_V1 = API_V1 + "/project-scopes";
    public static final String PROJECT_STATUS_V1 = API_V1 + "/project-statuses";
    public static final String CLIENT_V1 = API_V1 + "/client";
    public static final String PROJECT_OTHER_COST_ACTUAL_V1 = API_V1 + "/project-other-cost-actual";
    public static final String PROJECT_OTHER_COST_PLANNED_V1 = API_V1 + "/project-other-cost-planned";

    // Worker
    public static final String WORKER_TYPE_V1 = API_V1 + "/worker-types";
    public static final String WORKER_V1 = API_V1 + "/worker";

    //OtherItemCost
    public static final String OTHER_COST_ITEM_V1 = API_V1 + "/other-cost-item";


}
