package transport;

import transport.model.load.Load;
import transport.model.vehicle.Vehicle;

public interface TransportFactory {
    Vehicle createVehicle();
    Load createLoad();

}
