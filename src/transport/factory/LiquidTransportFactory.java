package transport.factory;

import transport.TransportFactory;
import transport.model.load.LiquidFuel;
import transport.model.load.LiquidLoad;
import transport.model.load.Load;
import transport.model.vehicle.Tanker;
import transport.model.vehicle.Vehicle;

public class LiquidTransportFactory implements TransportFactory {

    private String loadType;

    public LiquidTransportFactory(String loadType) {

        this.loadType = loadType;
    }

    @Override
    public Vehicle createVehicle() {
        return new Tanker("TA001", 1000);
    }

    @Override
    public Load createLoad() {
        if (loadType.equals("transport.model.load.LiquidFuel")) {
            return new LiquidFuel(500, 500);
        }
        return new LiquidLoad(500,500);

    }
}