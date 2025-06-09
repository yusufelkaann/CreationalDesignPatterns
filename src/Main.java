import transport.builder.OrderBuilder;
import transport.builder.ProjectBuilder;
import transport.factory.DryTransportFactory;
import transport.factory.LiquidTransportFactory;
import transport.factory.TrainTransportFactory;
import transport.TransportFactory;
import transport.manager.ProjectManager;
import transport.model.*;
import transport.model.load.LiquidFuel;
import transport.model.load.LiquidLoad;
import transport.model.load.Load;
import transport.model.vehicle.Vehicle;



public class Main {
    public static void main(String[] args) {
        try {
            // Abstract Factory: Create vehicles and loads
            TransportFactory liquidFactory = new LiquidTransportFactory("LiquidFuel");
            Vehicle tanker = liquidFactory.createVehicle();
            Load liquidFuel = liquidFactory.createLoad();

            TransportFactory dryFactory = new DryTransportFactory("TIR", "DryLoad");
            Vehicle tir = dryFactory.createVehicle();
            Load dryLoad = dryFactory.createLoad();

            TransportFactory trainFactory = new TrainTransportFactory();
            Vehicle train = trainFactory.createVehicle();
            Load trainLoad = trainFactory.createLoad();

            // Prototype: Clone drivers
            Driver driverTanker = new Driver("Alice", "ClassA", true, false);
            Driver driverTankerClone = driverTanker.clone();

            Driver driverTrain = new Driver("Bob", "ClassB", false, true);
            Driver driverTrainClone = driverTrain.clone();

            // Builder: Construct Order and Project
            OrderBuilder orderBuilder = new OrderBuilder()
                    .setStartLocation("Warehouse A")
                    .setEndLocation("Warehouse B")
                    .setLoad(liquidFuel)
                    .setPaymentType("Credit");
            Order order = orderBuilder.build();

            ProjectBuilder projectBuilder = new ProjectBuilder()
                    .setOrder(order)
                    .setDriver(driverTankerClone)
                    .setVehicle(tanker);
            Project project = projectBuilder.build();

            // Singleton: Use ProjectManager
            ProjectManager projectManager = ProjectManager.getInstance();
            projectManager.addProject(project);

            // Output results
            System.out.println("Abstract Factory Tests:");
            System.out.println("Tanker: ID=" + tanker.getId() + ", Class=" + tanker.getClass().getSimpleName() + ", Capacity=" + tanker.getCapacity());
            System.out.println("LiquidFuel: Class=" + liquidFuel.getClass().getSimpleName() + ", Weight=" + liquidFuel.getWeight() +
                    (liquidFuel instanceof LiquidFuel ? ", Volume=" + ((LiquidFuel) liquidFuel).getVolume() : ", Volume=N/A"));
            System.out.println("TIR: ID=" + tir.getId() + ", Class=" + tir.getClass().getSimpleName() + ", Capacity=" + tir.getCapacity());
            System.out.println("DryLoad: Class=" + dryLoad.getClass().getSimpleName() + ", Weight=" + dryLoad.getWeight());
            System.out.println("Train: ID=" + train.getId() + ", Class=" + train.getClass().getSimpleName() + ", Capacity=" + train.getCapacity());
            System.out.println("TrainLoad: Class=" + trainLoad.getClass().getSimpleName() + ", Weight=" + trainLoad.getWeight());

            System.out.println("\nPrototype Tests:");
            System.out.println("Driver Tanker: Name=" + driverTankerClone.getName() + ", License=" + driverTankerClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTankerClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTankerClone.isCanDriveTanker());
            System.out.println("Driver Train: Name=" + driverTrainClone.getName() + ", License=" + driverTrainClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTrainClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTrainClone.isCanDriveTanker());
            System.out.println("Original vs Clone: Same instance? " + (driverTanker == driverTankerClone));

            System.out.println("\nBuilder Tests:");
            System.out.println("Order: Start=" + order.getStartLocation() + ", End=" + order.getEndLocation() +
                    ", Load=" + order.getLoad().getClass().getSimpleName() + ", Payment=" + order.getPaymentType());
            System.out.println("Project: Order Start=" + project.getOrder().getStartLocation() +
                    ", Driver Name=" + project.getDriver().getName() + ", Vehicle=" + project.getVehicle().getClass().getSimpleName());

            System.out.println("\nSingleton Test:");
            ProjectManager anotherInstance = ProjectManager.getInstance();
            System.out.println("Single Instance? " + (projectManager == anotherInstance));
            System.out.println("Projects Count: " + projectManager.getProjects().size());

        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}