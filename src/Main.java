

public class Main {
    public static void main(String[] args) {
        try {
            // Test LiquidTransportFactory with LiquidFuel (requires canDriveTanker)
            TransportFactory liquidFuelFactory = new LiquidTransportFactory("LiquidFuel");
            Vehicle tankerFuel = liquidFuelFactory.createVehicle();
            Load fuelLoad = liquidFuelFactory.createLoad();
            Driver driverTanker = new Driver("Alice", "Class A", false, true); // Can drive Tanker
            Driver driverTankerClone = driverTanker.clone();

            System.out.println("LiquidTransportFactory (LiquidFuel):");
            System.out.println("Vehicle: ID=" + tankerFuel.getId() + ", Class=" + tankerFuel.getClass().getSimpleName() + ", Capacity=" + tankerFuel.getCapacity());
            System.out.print("Load: Class=" + fuelLoad.getClass().getSimpleName() + ", Weight=" + fuelLoad.getWeight());
            if (fuelLoad instanceof LiquidFuel) {
                System.out.println(", Volume=" + ((LiquidFuel) fuelLoad).getVolume());
            } else {
                System.out.println();
            }
            System.out.println("Driver: Name=" + driverTankerClone.getName() + ", License=" + driverTankerClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTankerClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTankerClone.isCanDriveTanker());
            System.out.println("Driver Original vs Clone: Same instance? " + (driverTanker == driverTankerClone));
            System.out.println("Driver can drive vehicle? " + (driverTankerClone.isCanDriveTanker() && tankerFuel.getClass().getSimpleName().equals("Tanker")));
            System.out.println();

            // Test LiquidTransportFactory with LiquidLoad (requires canDriveTanker)
            TransportFactory liquidLoadFactory = new LiquidTransportFactory("liquid");
            Vehicle tankerLoad = liquidLoadFactory.createVehicle();
            Load liquidLoad = liquidLoadFactory.createLoad();
            Driver driverTankerBoth = new Driver("Bob", "Class B", true, true); // Can drive Train and Tanker
            Driver driverTankerBothClone = driverTankerBoth.clone();

            System.out.println("LiquidTransportFactory (liquid):");
            System.out.println("Vehicle: ID=" + tankerLoad.getId() + ", Class=" + tankerLoad.getClass().getSimpleName() + ", Capacity=" + tankerLoad.getCapacity());
            System.out.print("Load: Class=" + liquidLoad.getClass().getSimpleName() + ", Weight=" + liquidLoad.getWeight());
            if (liquidLoad instanceof LiquidLoad) {
                System.out.println(", Volume=" + ((LiquidLoad) liquidLoad).getVolume());
            } else {
                System.out.println();
            }
            System.out.println("Driver: Name=" + driverTankerBothClone.getName() + ", License=" + driverTankerBothClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTankerBothClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTankerBothClone.isCanDriveTanker());
            System.out.println("Driver Original vs Clone: Same instance? " + (driverTankerBoth == driverTankerBothClone));
            System.out.println("Driver can drive vehicle? " + (driverTankerBothClone.isCanDriveTanker() && tankerLoad.getClass().getSimpleName().equals("Tanker")));
            System.out.println();

            // Test DryTransportFactory with TIR and DryLoad (no special license needed)
            TransportFactory dryLoadFactory = new DryTransportFactory("DryLoad", "TIR");
            Vehicle tir = dryLoadFactory.createVehicle();
            Load dryLoad = dryLoadFactory.createLoad();
            Driver driverDefault = new Driver("Charlie", "Class C", false, false); // Can drive Truck/TIR only
            Driver driverDefaultClone = driverDefault.clone();

            System.out.println("DryTransportFactory (TIR, DryLoad):");
            System.out.println("Vehicle: ID=" + tir.getId() + ", Class=" + tir.getClass().getSimpleName() + ", Capacity=" + tir.getCapacity());
            System.out.println("Load: Class=" + dryLoad.getClass().getSimpleName() + ", Weight=" + dryLoad.getWeight());
            System.out.println("Driver: Name=" + driverDefaultClone.getName() + ", License=" + driverDefaultClone.getLicenseType() +
                    ", CanDriveTrain=" + driverDefaultClone.isCanDriveTrain() + ", CanDriveTanker=" + driverDefaultClone.isCanDriveTanker());
            System.out.println("Driver Original vs Clone: Same instance? " + (driverDefault == driverDefaultClone));
            System.out.println("Driver can drive vehicle? " + (tir.getClass().getSimpleName().equals("TIR") || tir.getClass().getSimpleName().equals("Truck")));
            System.out.println();

            // Test DryTransportFactory with Truck and DryFood (no special license needed)
            TransportFactory dryFoodFactory = new DryTransportFactory("DryFood", "Truck");
            Vehicle truck = dryFoodFactory.createVehicle();
            Load dryFood = dryFoodFactory.createLoad();
            Driver driverTruckTrain = new Driver("Dave", "Class D", true, false); // Can drive Train and Truck/TIR
            Driver driverTruckTrainClone = driverTruckTrain.clone();

            System.out.println("DryTransportFactory (Truck, DryFood):");
            System.out.println("Vehicle: ID=" + truck.getId() + ", Class=" + truck.getClass().getSimpleName() + ", Capacity=" + truck.getCapacity());
            System.out.println("Load: Class=" + dryFood.getClass().getSimpleName() + ", Weight=" + dryFood.getWeight());
            System.out.println("Driver: Name=" + driverTruckTrainClone.getName() + ", License=" + driverTruckTrainClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTruckTrainClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTruckTrainClone.isCanDriveTanker());
            System.out.println("Driver Original vs Clone: Same instance? " + (driverTruckTrain == driverTruckTrainClone));
            System.out.println("Driver can drive vehicle? " + (truck.getClass().getSimpleName().equals("TIR") || truck.getClass().getSimpleName().equals("Truck")));
            System.out.println();

            // Test TrainTransportFactory (requires canDriveTrain)
            TransportFactory trainFactory = new TrainTransportFactory();
            Vehicle train = trainFactory.createVehicle();
            Load trainLoad = trainFactory.createLoad();
            Driver driverTrain = new Driver("Eve", "Class E", true, false); // Can drive Train
            Driver driverTrainClone = driverTrain.clone();

            System.out.println("TrainTransportFactory:");
            System.out.println("Vehicle: ID=" + train.getId() + ", Class=" + train.getClass().getSimpleName() + ", Capacity=" + train.getCapacity());
            System.out.println("Load: Class=" + trainLoad.getClass().getSimpleName() + ", Weight=" + trainLoad.getWeight());
            System.out.println("Driver: Name=" + driverTrainClone.getName() + ", License=" + driverTrainClone.getLicenseType() +
                    ", CanDriveTrain=" + driverTrainClone.isCanDriveTrain() + ", CanDriveTanker=" + driverTrainClone.isCanDriveTanker());
            System.out.println("Driver Original vs Clone: Same instance? " + (driverTrain == driverTrainClone));
            System.out.println("Driver can drive vehicle? " + (driverTrainClone.isCanDriveTrain() && train.getClass().getSimpleName().equals("Train")));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}