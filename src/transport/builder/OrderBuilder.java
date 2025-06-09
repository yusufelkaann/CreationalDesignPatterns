package transport.builder;

import transport.model.load.Load;
import transport.model.Order;

public class OrderBuilder {
    private String startLocation;
    private String endLocation;
    private Load load;
    private String paymentType;

    public OrderBuilder() {
        this.startLocation = "";
        this.endLocation = "";
        this.load = null;
        this.paymentType = "Cash"; // Default payment type
    }

    public OrderBuilder setStartLocation(String location) {
        this.startLocation = location != null ? location : "";
        return this;
    }

    public OrderBuilder setEndLocation(String location) {
        this.endLocation = location != null ? location : "";
        return this;
    }

    public OrderBuilder setLoad(Load load) {
        this.load = load;
        return this;
    }

    public OrderBuilder setPaymentType(String type) {
        this.paymentType = type != null ? type : "Cash";
        return this;
    }

    public Order build() {
        if (startLocation.isEmpty()) {
            throw new IllegalStateException("Start location cannot be empty");
        }
        if (endLocation.isEmpty()) {
            throw new IllegalStateException("End location cannot be empty");
        }
        if (load == null) {
            throw new IllegalStateException("transport.model.load.Load cannot be null");
        }
        if (paymentType.isEmpty()) {
            throw new IllegalStateException("Payment type cannot be empty");
        }
        return new Order(startLocation, endLocation, load, paymentType);
    }
}