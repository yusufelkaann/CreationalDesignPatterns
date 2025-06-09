package transport.factory;

import transport.TransportFactory;
import transport.model.load.DryFood;
import transport.model.load.DryLoad;
import transport.model.load.Load;
import transport.model.vehicle.TIR;
import transport.model.vehicle.Truck;
import transport.model.vehicle.Vehicle;

public class DryTransportFactory implements TransportFactory {

    private String loadType;
    private String vehicleType;

    public DryTransportFactory(String loadType, String vehicleType) {
        this.loadType = loadType;
        this.vehicleType = vehicleType;
    }
    @Override
    public Vehicle createVehicle() {
        if (vehicleType.equals("transport.model.vehicle.TIR")) {
            return new TIR("TIR001",  1000);
        } else if (vehicleType.equals("transport.model.vehicle.Truck")) {
            return new Truck("TK001",  1000);
        }
        return new TIR("TIR001",  1000);
    }

    @Override
    public Load createLoad() {
        if (loadType.equals("transport.model.load.DryLoad")) {
            return new DryLoad( 1000);
        } else if (loadType.equals("transport.model.load.DryFood")) {
            return new DryFood( 1000);
        }
        return new DryFood( 1000);
    }

}
