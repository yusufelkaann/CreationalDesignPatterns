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
        if (loadType.equals("LiquidFuel")) {
            return new LiquidFuel(500, 500);
        }
        return new LiquidLoad(500,500);

    }
}