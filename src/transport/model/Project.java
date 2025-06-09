package transport.model;

import transport.model.vehicle.Vehicle;

public class Project {
    private final Order order;
    private final Driver driver;
    private final Vehicle vehicle;

    public Project(Order order, Driver driver, Vehicle vehicle) {
        this.order = order;
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public Order getOrder() {
        return order;
    }

    public Driver getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}