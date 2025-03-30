package in.oxidane.work.done.common.constant;

public class Endpoints {

    public static final String BASE_URL = "https://api.oxidane.in";

    public static final String API_V1 = "/api/v1";

    // health check
    public static final String HEALTH_CHECK = "/health/check";

    // Building
    public static final String UNIT_TYPE_V1 = API_V1 + "/unit-types";

    // Material
    public static final String MATERIAL_V1 = API_V1 + "/materials";
    public static final String MATERIAL_MANUFACTURER_V1 = API_V1 + "/material-manufacturers";
    public static final String MATERIAL_VENDOR_V1 = API_V1 + "/material-vendors";
    public static final String MATERIAL_TYPE_V1 = API_V1 + "/material-types";

    // Order
    public static final String WORK_ORDER_V1 = API_V1 + "/work-orders";
    public static final String LINE_ITEM_V1 = API_V1 + "/line-items";
    public static final String LINE_ITEM_MATERIAL_V1 = API_V1 + "/line-item-materials";
    public static final String LINE_ITEM_WORKER_V1 = API_V1 + "/line-item-workers";
    public static final String UNIT_OF_MEASUREMENT_V1 = API_V1 + "/unit-of-measurements";

    // Project
    public static final String CUSTOMER_V1 = API_V1 + "/customers";
    public static final String PROJECT_V1 = API_V1 + "/projects";
    public static final String PROJECT_SCOPE_V1 = API_V1 + "/project-scopes";
    public static final String PROJECT_STATUS_V1 = API_V1 + "/project-statuses";

    // Worker
    public static final String WORKER_TYPE_V1 = API_V1 + "/worker-types";
}
