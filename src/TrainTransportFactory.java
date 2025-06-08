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
