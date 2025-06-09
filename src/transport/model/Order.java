package transport.model;

import transport.model.load.Load;

public class Order {
    private final String startLocation;
    private final String endLocation;
    private final Load load;
    private final String paymentType;

    public Order(String startLocation, String endLocation, Load load, String paymentType) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.load = load;
        this.paymentType = paymentType;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public Load getLoad() {
        return load;
    }

    public String getPaymentType() {
        return paymentType;
    }
}
