package cz.datbp2025.veverkyukol.model;

public class DayCampOrder {

    private final OrderData common;
    private final DayCampData details;

    public DayCampOrder() {
        this.common = new OrderData.Builder().defaultData().build();
        this.details = new DayCampData(DayCampData.CourseTime.PM, 10, "8-10", 2);
    }

    public DayCampOrder(OrderData common, DayCampData details) {
        this.common = common;
        this.details = details;
    }

    public OrderData common() {
        return common;
    }

    public DayCampData details() {
        return details;
    }


}