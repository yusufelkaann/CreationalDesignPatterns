package transport.factory;

import transport.TransportFactory;
import transport.model.load.DryLoad;
import transport.model.load.Load;
import transport.model.vehicle.Train;
import transport.model.vehicle.Vehicle;

public class TrainTransportFactory implements TransportFactory {

    @Override
    public Vehicle createVehicle() {
        return new Train("TN001", 5000);
    }

    @Override
    public Load createLoad() {
        return new DryLoad(500);
    }
}
