package transport.builder;

import transport.model.Driver;
import transport.model.Order;
import transport.model.Project;
import transport.model.vehicle.Vehicle;

public class ProjectBuilder {
    private Order order;
    private Driver driver;
    private Vehicle vehicle;

    public ProjectBuilder() {
        this.order = null;
        this.driver = null;
        this.vehicle = null;
    }

    public ProjectBuilder setOrder(Order order) {
        this.order = order;
        return this;
    }

    public ProjectBuilder setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public ProjectBuilder setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Project build() {
        if (order == null) {
            throw new IllegalStateException("transport.model.Order cannot be null");
        }
        if (driver == null) {
            throw new IllegalStateException("transport.model.Driver cannot be null");
        }
        if (vehicle == null) {
            throw new IllegalStateException("transport.model.vehicle.Vehicle cannot be null");
        }
        return new Project(order, driver, vehicle);
    }
}