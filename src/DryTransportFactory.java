

public class DryTransportFactory implements TransportFactory{

    private String loadType;
    private String vehicleType;

    public DryTransportFactory(String loadType, String vehicleType) {
        this.loadType = loadType;
        this.vehicleType = vehicleType;
    }
    @Override
    public Vehicle createVehicle() {
        if (vehicleType.equals("TIR")) {
            return new TIR("TIR001",  1000);
        } else if (vehicleType.equals("Truck")) {
            return new Truck("TK001",  1000);
        }
        return new TIR("TIR001",  1000);
    }

    @Override
    public Load createLoad() {
        if (loadType.equals("DryLoad")) {
            return new DryLoad( 1000);
        } else if (loadType.equals("DryFood")) {
            return new DryFood( 1000);
        }
        return new DryFood( 1000);
    }

}
